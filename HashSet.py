# Time Complexity : O(1) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashSet:

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.storage = [None]* self.primaryBuckets
        
    def getPrimaryHash(self, key):
        return key % self.primaryBuckets
    
    def getSecondaryHash(self, key):
        return key // self.secondaryBuckets
        
    def add(self, key: int):
        primaryIndex =  self.getPrimaryHash(key)
        if(self.storage[primaryIndex] == None):
            if(primaryIndex == 0):
                self.storage[primaryIndex] = [False]*(self.secondaryBuckets+1)
            else:
                self.storage[primaryIndex] = [False]*self.secondaryBuckets
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self,key: int):
        primaryIndex = self.getPrimaryHash(key)
        if(self.storage[primaryIndex] == None):
            return
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = False
        
    def contains(self,key: int)-> bool:
        primaryIndex = self.getPrimaryHash(key)
        if(self.storage[primaryIndex] == None):
            return False
        secondaryIndex = self.getSecondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex]
                