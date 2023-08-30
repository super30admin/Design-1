# Time and space Complexity for add/remove/contains is O(1)
class MyHashSet(object):
    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1001
        self.hashset = [None] * self.buckets
        
    def getBucket(self,key):
        return key % self.buckets
    
    def getBucketitems(self, key):
        return key // self.bucketitems
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketitem = self.getBucketitems(key)
        
        if self.hashset[bucket] == None:
            self.hashset[bucket] = [False] * self.bucketitems 
        self.hashset[bucket][bucketitem] = True
        


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketitem = self.getBucketitems(key)
        
        if self.hashset[bucket]:
            self.hashset[bucket][bucketitem] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.getBucket(key)
        bucketitem = self.getBucketitems(key)
        return self.hashset[bucket] and self.hashset[bucket][bucketitem]
        
        
        
myHashSet = MyHashSet()
myHashSet.add(1)      # set = [1]
myHashSet.add(2)      # set = [1, 2]
myHashSet.contains(1) # return True
myHashSet.contains(3) # return False, (not found)
myHashSet.add(2)      # set = [1, 2]
myHashSet.contains(2) # return True
myHashSet.remove(2)   # set = [1]
myHashSet.contains(2) # return False, (already removed)