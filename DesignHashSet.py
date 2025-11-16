'''
In this problem we are designing a data structure - HashSet

Using double hashing technique: 
    1. key % 1000
    2. key // 1000

add(key):
we find the primary index and secondary index, 
check if the primary array is created, if not we create a primary array, with a size of 1001 at index 0 and secondary array is created only when needed
we can the boolean value to true when we want to add a key at [primary][secondary] index,

remove(key):
using 2 hash functions we find the exact index of the element and make it to false

contains(key):
again we find eaxct index of the key and return the boolean value from that point
'''


class MyHashSet:

    def __init__(self):
        self.primary = 1000
        self.secondary = 1000
        self.storage = [None] * self.primary
    
    def hash1(self, key: int) -> int:
        return key % 1000
    
    def hash2(self, key: int) -> int:
        return key // 1000

    def add(self, key: int) -> None:
        primary = self.hash1(key)
        secondary = self.hash2(key)
        if self.storage[primary] is None:
            if primary == 0:
                self.storage[primary] = [False] * (self.secondary + 1)
            else:
                self.storage[primary] = [False] * self.secondary
        self.storage[primary][secondary] = True

    def remove(self, key: int) -> None:
        primary = self.hash1(key)
        secondary = self.hash2(key)

        if self.storage[primary] is None:
            return
        
        self.storage[primary][secondary] = False

    def contains(self, key: int) -> bool:
        primary = self.hash1(key)
        secondary = self.hash2(key)

        if self.storage[primary] is None:
            return False
        
        return self.storage[primary][secondary]
