#to add in hashset get bucket and bucketitems from defined methods and if bucket has no items add to bucket and set as True
#to remove from hashset set bucket and bucketitems as None
# to check if items are in hashset get bucket and bucketitem and return their index value
class MyHashSet:

    def __init__(self):
        self.bucket=1000
        self.bucketItems=1000
        self.storage=[None]*self.bucket
    
    def getBucket(self,key:int)->int:
        return key%self.bucket
    
    def getBucketItems(self,key:int)->int:
        return key//self.bucketItems

    def add(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        if self.storage[bucket]==None:
            self.storage[bucket]=[None]*self.bucketItems

        self.storage[bucket][bucketItems] = True

    def remove(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        if self.storage[bucket]==None:
            return
        self.storage[bucket][bucketItems] = None

    def contains(self, key: int) -> bool:
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        if self.storage[bucket]==None:
            return False
        return self.storage[bucket][bucketItems]
