# Time Complexity : O(1) for all the methods
# Space Complexity : O(10^6) worst case where all 1000 buckets have atleast one key
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : missed edge case of key = 10^6

# Approach:
# Primary static array, through modulo hash function, is used to point buckets, 
# where each bucket is another static array with another hash function, division. 
# secondary array is created only when a key falls in that bucket.
# this is called double hashing and enables for constant time complexity for contains, add and remove operations.


class MyHashSet:

    def __init__(self):
        self.hashSize = 1000 #square root of total space.
        self.hashTable = [None] * self.hashSize #initialising with Null pointers

    def add(self, key: int) -> None:
        idx1 = key % self.hashSize
        if not self.hashTable[idx1] and idx1:
            self.hashTable[idx1] = [False] * self.hashSize #create a secondary hash table only when an element exists in the bucket
        elif not self.hashTable[idx1] and idx1 == 0:
            self.hashTable[idx1] = [False] * (self.hashSize+1) #for key=10^6, 0th index needs extra cell
        
        idx2 = key // self.hashSize #secondary index
        if not self.contains(key):
            self.hashTable[idx1][idx2] = True

    def remove(self, key: int) -> None: #O(1)
        if self.contains(key):
            idx1 = key % self.hashSize
            idx2 = key // self.hashSize
            self.hashTable[idx1][idx2] = False

    def contains(self, key: int) -> bool: #O(1)
        idx1 = key % self.hashSize
        if self.hashTable[idx1]:
            idx2 = key // self.hashSize
            if self.hashTable[idx1][idx2]:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)