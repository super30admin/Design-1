# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.storage = [None]*self.buckets 
    
    def getBucket(self, key: int):
        return key % self.buckets

    def getBucketItem(self, key: int):
        return key // self.buckets
    
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None and bucket == 0:           # edge case as the upper bound needs to be stored, it needs one more index.
            self.storage[bucket] = [False] * (self.buckets + 1)
        elif self.storage[bucket] == None:
            self.storage[bucket] = [False] * self.buckets
        self.storage[bucket][bucketItem] = True
            

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket]:     # Not checking the specific item as it NoneType object is not subscriptable, if the item does not exists, it's false anyway.
            self.storage[bucket][bucketItem] = False
        else:
            return 

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket]:
            return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)