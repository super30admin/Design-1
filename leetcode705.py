#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Feb  3 22:01:46 2026

@author: rishigoswamy

    Approach:
    ----------
    Since the key range is bounded (0 <= key <= 10^6), we can use a
    two-level hashing.

    The idea is to split the key into two parts:
    - Primary index  = key % 1000
    - Secondary index = key // 1000

    This maps each key uniquely to a position in a 2D boolean table.
    The secondary array size is 1001 to handle the maximum key value
    (1_000_000 // 1000 = 1000).

    Because each (primary, secondary) pair uniquely represents a key,
    there are no collisions.

    Time Complexity:
    ----------------
    add      : O(1)
    remove   : O(1)
    contains : O(1)

    Space Complexity:
    -----------------
    O(n), due to the fixed-size 2D table used for direct addressing.
    

"""

class MyHashSet:

    def __init__(self):
        self.primaryArraySize = 1000
        self.secondaryArraySize = 1001
        self.table = [[False] * self.secondaryArraySize for _ in range(self.primaryArraySize)]
        
    def hashKeys(self, key: int):
        return [key % self.primaryArraySize, key // self.primaryArraySize ]

    def add(self, key: int) -> None:
        primaryKey = self.hashKeys(key)[0]
        secondaryKey = self.hashKeys(key)[1]
        self.table[primaryKey][secondaryKey] = True 

    def remove(self, key: int) -> None:
        primaryKey = self.hashKeys(key)[0]
        secondaryKey = self.hashKeys(key)[1]
        self.table[primaryKey][secondaryKey] = False
        
    def contains(self, key: int) -> bool:
        primaryKey = self.hashKeys(key)[0]
        secondaryKey = self.hashKeys(key)[1]
        return self.table[primaryKey][secondaryKey]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)