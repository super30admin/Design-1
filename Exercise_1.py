# Time Complexity: O(1)
# Space Complexity: O(10^6) = O(N) -> In worse case
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class MyHashSet(object):

    def __init__(self):
        self.bucket = 1000
        self.bucketSize = 1000
        self.storage = [False]*self.bucket

    def getHash1(self, key):
        return key % self.bucket
    
    def getHash2(self, key):
        return key/self.bucketSize
    
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = self.getHash1(key)
        hash2 = self.getHash2(key)
        if (not self.storage[hash1]) and hash1==0:
            self.storage[hash1] = [False]*(self.bucketSize+1)
        elif (not self.storage[hash1]):
            self.storage[hash1] = [False]*self.bucketSize
        self.storage[hash1][hash2] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = self.getHash1(key)
        hash2 = self.getHash2(key)
        if (self.storage[hash1]):
            self.storage[hash1][hash2] = False
        
    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hash1 = self.getHash1(key)
        hash2 = self.getHash2(key)
        if (self.storage[hash1]):
            return self.storage[hash1][hash2]
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)