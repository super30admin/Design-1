class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketitems = 1000
        self.storage = self.bucket * [None]
        
    def getbucket(self,key):
        return (key % self.bucket)
    
    def getbucketitems(self,key):
        return (int(key / self.bucket))

    def add(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketitems = self.getbucketitems(key)
        if(self.storage[bucket] is None):
            if(bucket == 0):
                self.storage[bucket] = [None] * (self.bucketitems+1)
            else:
                self.storage[bucket] = [None] * self.bucketitems
        self.storage[bucket][bucketitems] = True

    def remove(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketitems = self.getbucketitems(key)
        if(self.storage[bucket] is None):
            return
        self.storage[bucket][bucketitems] = False
            
        

    def contains(self, key: int) -> bool:
        bucket = self.getbucket(key)
        bucketitems = self.getbucketitems(key)
        if(self.storage[bucket] is None):
            return False
        return self.storage[bucket][bucketitems] 
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)