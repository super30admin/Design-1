# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#I have used Double Hashing to implement HashSet

class MyHashSet:

    def __init__(self):
        self.data = 1000
        self.innerdata = 1000
        self.storage = [None] * self.data

    def hash1(self, key):
        index = key % self.data
        return index

    def hash2(self, key):
        index = key // self.innerdata
        return index

    def add(self, key:int) -> None:
        data_index = self.hash1(key)
        innerdata_index = self.hash2(key)
        if self.storage[data_index] is None:
            if data_index == 0:
                self.storage[data_index] = [False] * (self.innerdata + 1)
            else:
                self.storage[data_index] = [False] * self.innerdata
        self.storage[data_index][innerdata_index] = True

    def remove(self, key:int) -> None:
        data_index = self.hash1(key)
        innerdata_index = self.hash2(key)
        if self.storage[data_index] is None:
            return
        self.storage[data_index][innerdata_index] = False

    def contains(self, key:int) -> bool:
        data_index = self.hash1(key)
        innerdata_index = self.hash2(key)
        if self.storage[data_index] is None:
            return False
        return self.storage[data_index][innerdata_index]

    
    