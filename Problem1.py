class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None] * self.buckets

    def getbucket(self, key):
        return key % self.buckets

    def getbucketitems(self, key):
        return key//self.bucketitems

    # Adding into hashset will take O(1) time complexity
    def add(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketlist = self.getbucketitems(key)
        if(self.storage[bucket] == None):
            if(bucket == 0):
                self.storage[bucket] = [None]*(self.bucketitems+1)
            else:
                self.storage[bucket] = [None]*self.bucketitems
        self.storage[bucket][bucketlist] = True

# Removing From hashset will take O(1) time complexity
    def remove(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketlist = self.getbucketitems(key)
        if self.storage[bucket] == None:
            pass
        elif self.storage[bucket][bucketlist] == None:
            pass
        else:
            self.storage[bucket][bucketlist] = None
# lookup will take O(1) time

    def contains(self, key: int) -> bool:
        bucket = self.getbucket(key)
        bucketlist = self.getbucketitems(key)
        if self.storage[bucket] == None:
            return False
        elif self.storage[bucket][bucketlist] == None:
            return False
        else:
            return True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
