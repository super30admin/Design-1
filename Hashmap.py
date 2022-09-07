class MyHashMap(object):
    
    def __init__(self):
        self.size = 10000
        self.buckets = [[] for _ in range(self.size)]

    def getBucket(self, key):
        return self.buckets[key % self.size]

    def findIndexOfKey(self, bucket, key):
        for i, (k, v) in enumerate(bucket):
            if k == key:
                return i
        return -1

    def put(self, key, value):
        bucket = self.getBucket(key)
        index = self.findIndexOfKey(bucket, key)
        if index != -1:
            bucket[index][1] = value
        else:
            bucket.append([key, value])

    def get(self, key):
        bucket = self.getBucket(key)
        index = self.findIndexOfKey(bucket, key)
        if index == -1: return -1
        return bucket[index][1]

    def remove(self, key):
        bucket = self.getBucket(key)
        index = self.findIndexOfKey(bucket, key)
        if index == -1: return
        del bucket[index]