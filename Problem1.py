class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None]*self.buckets
    def getbucket(self,key):
        return key%self.buckets
    def getbucketitems(self,key):
        return key//self.bucketitems
            

    def add(self, key: int) -> None:
        
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        if (self.storage[bucket] is None):
            if(bucket == 0):
                self.storage[bucket] = [False]*(self.bucketitems+1)
            else :
                self.storage[bucket] = [False]*self.bucketitems
        self.storage[bucket][bucketitem] = True
    def prin(self,key):
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        return self.storage[bucket][bucketitem]


    def remove(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        if(self.storage[bucket] is None):
            return 
        self.storage[bucket][bucketitem] = False
    def contains(self, key: int) -> bool:
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        if(self.storage[bucket] is None):
            return False
        return self.storage[bucket][bucketitem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)