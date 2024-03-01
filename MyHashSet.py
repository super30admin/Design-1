# Time Complexity : add, remove, contains O(1)
# Space Complexity : Best Case O(1), Worst Case O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is not None:
            self.storage[bucket][bucketItem] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        return self.storage[bucket] is not None and self.storage[bucket][bucketItem]

    def hash1(self, key: int) -> int:
        return key % self.buckets
    
    def hash2(self, key: int) -> int:
        return key // self.bucketItems
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)