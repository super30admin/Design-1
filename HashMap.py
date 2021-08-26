#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Aug 23 17:58:22 2021

@author: ameeshas11
"""


#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
    
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #create a initial array for size 1000
        self.list_one = [0]*1000
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        find_key = key % 1000
        new_key = key//1000
        #if there was nothing at the key in first array make a new array of size 1000 and assign value
        if self.list_one[find_key] == 0:
            #if the index is 0 assign one extra element to avoid collision
            if find_key != 0:
                list_two = [-1]*1000
            else:
                list_two = [-1]*1001
            #assign value using double hashing
            list_two[new_key] = value
            self.list_one[find_key] = list_two
        else:
            #change old value by new one
            list_two = self.list_one[find_key]
            list_two[new_key] = value
            

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        find_key = key%1000
        new_key = key//1000
        #if there is no second array return -1
        if self.list_one[find_key] == 0:
            return -1
        #return value in second array either number or -1
        else:
            list_two = self.list_one[find_key]
            return list_two[new_key]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        find_key = key%1000
        new_key = key//1000
        #update the value in second array if it exists
        if self.list_one[find_key] != 0:
            list_two = self.list_one[find_key]
            list_two[new_key] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)