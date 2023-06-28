class MyHashSet:
    #Time Complexity :O(1)
    #Space Complexity :O(n)
    #Did this code successfully run on Leetcode : Yes
    #Any problem you faced while coding this : No

    #Used double hashing for collision. 
    #we create buckets which contains pointer to the bucketitems array. We can mark it as True or False to the position based on the hashed values for the key in the bucket.
    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.storage=[None]*(self.buckets)

    def hash1(self,key):
        return int(key%self.buckets)

    def hash2(self,key):
        return int(key/self.bucketItems)

    def add(self, key: int) -> None:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket] is None:
            #if bucket==0:
            #    self.storage[bucket]=[False]*(self.bucketItems+1)
            #else:
                self.storage[bucket]=[False]*(self.bucketItems)
        self.storage[bucket][bucketItem]=True

    def remove(self, key: int) -> None:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][bucketItem]=False

    def contains(self, key: int) -> bool:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket] is None:
            return False
        else:
            return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)