#Time Complexity :O(1)
#Space Complexity :O(m*n) where  m is size of bucket and n is the size of bucketitems
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
#Followed the approach thaught in the class. 

class MyHashSet:
    #creating bucket and bucketItems with specified size
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    # Returning the bucket index for a given key.
    def _bucket(self, key):
        return key % self.buckets

    # Returning the bucket item index for a given key.
    def _bucketItem(self, key):
        return key // self.bucketItems

    # Adding key to HashSet and also finding the bucket index and bucketItem Idenx and storing the key.
    def add(self, key):
        bucket = self._bucket(key)
        bucketItem = self._bucketItem(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True

    # finds the bucket and bucketItem index and sets keys value to false
    def remove(self, key):
        bucket = self._bucket(key) 
        bucketItem = self._bucketItem(key) 
        if self.storage[bucket] is not None:
            self.storage[bucket][bucketItem] = False

    #finds the bucket and bucketItem index and returns true if found else false.
    def contains(self, key):
        bucket = self._bucket(key) 
        bucketItem = self._bucketItem(key)
        return self.storage[bucket] is not None and self.storage[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)