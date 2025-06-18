class MyHashSet:

    def __init__(self):
        self.bucket=1000
        self.bucketItem=1000
        self.storage=[None]*self.bucket  

    def getBucket(self, key):
        return key%self.bucket
    
    def getBucketItem(self, key):
        return key//self.bucketItem

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucket + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItem
        bucketItem = self.getBucketItem(key)
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] is None:
            return
        bucketItem=self.getBucketItem(key)
        self.storage[bucket][bucketItem]=False
        

    def contains(self, key: int) -> bool:
        bucket=self.getBucket(key)
        if self.storage[bucket] is None:
            return False
        bucketItem=self.getBucketItem(key)
        return self.storage[bucket][bucketItem]