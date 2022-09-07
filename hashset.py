# Time Complexity :O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :none

class MyHashSet(object):

    def __init__(self):
        self.size=1000
        self.bucket=[None]*sel.size
    def hash1(self,key):
        return key%self.size 
    
    def hash2(self,key): 
        return key//self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hi = self.hash1(key)
        dhi = self.hash2(key)
        if not self.bucket[hi] and hi==0: 
            self.bucket[hi]= [False]*(self.size+1)
        elif not self.bucket[hi]: 
            self.bucket[hi]=[False]*(self.size)
        self.bucket[hi][dhi]= True 
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hi= self.hash1(key)
        dhi = self.hash2(key)
        if self.bucket[hi]: 
            self.bucket[hi][dhi]= False 
        
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hi = self.hash1(key)
        dhi = self.hash2(key)
        if self.bucket[hi]:
            return self.bucket[hi][dhi]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
