#for bucket and bucket items we have 1000 predefined size and hash function for getting value for bucket and bucket items
#in put method if bucket is none initialize new item 
#in get method return true if bucket and bucket item found otherwise false
#for remove set bucket and bucket item to none
class MyHashMap(object):

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def getBucket(self, key):
        return key % self.buckets

    def getBucketItems(self, key):
        return key // self.bucketItems

    def put(self, key, value):
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItems

        self.storage[bucket][bucketItem] = True
        

    def get(self, key):
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] is None:
            return False

        return self.storage[bucket][bucketItem] is True
        

    def remove(self, key):
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] is not None and self.storage[bucket][bucketItem] is not None:
            self.storage[bucket][bucketItem] = None