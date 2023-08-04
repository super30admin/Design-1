#Time Complexity : O(1) for all the operation that is add, remove and contains
#Space Complexity : O(N) where N is the number of unique keys that has been added. This is because storage array is used to store the key-value pairs, and the size of the storage array grows lineraly with the number of unique keys.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None for i in range(self.buckets)]

    def hash1(self, key: int):
        return key % 1000
    
    def hash2(self, key: int):
        return key // 1000

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if not self.storage[bucket]:
            if bucket == 0:
                self.storage[bucket] = [False for i in range(self.bucketItems + 1)]
            else:
                self.storage[bucket] = [False for i in range(self.bucketItems)]
        
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if not self.storage[bucket]:
            return
        self.storage[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if not self.storage[bucket]:
            return False
        return self.storage[bucket][bucketItem]