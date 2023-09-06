# Time Complexity : O(1)
# Space Complexity : O(N)


class MyHashSet(object):

    def __init__(self):
        self.buckets =1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets 

    def bucketHash(self, key):
        return key % self.buckets

    
    def bucketItemHash(self, key):
        return key // self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.bucketHash(key)
        bucketItem = self.bucketItemHash(key)
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItems
        self.storage[bucket][bucketItem] = True


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.bucketHash(key)
        bucketItem = self.bucketItemHash(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False


    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.bucketHash(key)
        bucketItem = self.bucketItemHash(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
