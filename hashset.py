# // Time Complexity : add, remove and contains operations are O(1) 
# // Space Complexity : O(buckets * bucket_size) maximum space used when all the buckets are filled
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA

class MyHashSet(object):
    buckets = 1000
    bucket_size=1001

    def __init__(self):
        self.hashset=[None] * self.buckets

    def hashfunc1(self,key):
        return key % self.buckets
    
    def hashfunc2(self,key):
        return key // self.bucket_size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_bucket = self.hashfunc1(key)
        secondary_index = self.hashfunc2(key)
        if self.hashset[primary_bucket] is None:
            self.hashset[primary_bucket] = [False] * self.bucket_size
        
        self.hashset[primary_bucket][secondary_index] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        
        primary_bucket = self.hashfunc1(key)
        secondary_index = self.hashfunc2(key)

        if self.hashset[primary_bucket] is not None:
            self.hashset[primary_bucket][secondary_index]=False  
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primary_bucket = self.hashfunc1(key)
        secondary_index = self.hashfunc2(key)

        if self.hashset[primary_bucket] is not None:
            return self.hashset[primary_bucket][secondary_index]

        return False 
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)