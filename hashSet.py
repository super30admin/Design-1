class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hs=[False]*1000
        self.buckets=1000
        self.bucketItems=1000
        
    def getFirstHash(self, key): #Time complexity O(1)
        return key % self.buckets
    
    def getSecondHash(self,key): #Time complexity O(1)
        return key//self.bucketItems
    
    def add(self, key): #Time complexity O(1)
        firstHashVal=self.getFirstHash(key)
        secondHashVal=self.getSecondHash(key)
        if self.hs[firstHashVal]==False:
            if firstHashVal==0:
                self.hs[firstHashVal]=[False]*(self.bucketItems+1)
            else:
                self.hs[firstHashVal]=[False]*(self.bucketItems)
        self.hs[firstHashVal][secondHashVal]=True

    def remove(self, key): #Time complexity O(1)
        firstHashVal=self.getFirstHash(key)
        secondHashVal=self.getSecondHash(key)
        if self.hs[firstHashVal]==False:
            return -1
        
        self.hs[firstHashVal][secondHashVal]=False
        

    def contains(self, key): #Time complexity O(1)
        """
        Returns true if this set contains the specified element
        """
        firstHashVal=self.getFirstHash(key)
        secondHashVal=self.getSecondHash(key)
        if self.hs[firstHashVal]==False:
            return False
        else:
            return self.hs[firstHashVal][secondHashVal]
        
        
#Overall time complexity: O(1)
#Overall space complexity : worst case O(maxAllowedSpace) i.e. 10^6 in this case.

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)