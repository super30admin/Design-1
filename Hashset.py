'''
This class MyHashSet implements a simple hash set using bucket indexing. The 'add', 'remove' and 'contains' operations are facilitated by two hash functions - getBucket and getBucketItems. These functions determine the correct bucket and item position within the bucket, thus enabling efficient storage and retrieval.
'''

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def getBucket(self, key:int) -> int:
        return key % self.buckets

    def getBucketItems(self, key:int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItems

        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] is not None and self.storage[bucket][bucketItem] is not None:
            self.storage[bucket][bucketItem] = None

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] is None:
            return False

        return self.storage[bucket][bucketItem] is True
