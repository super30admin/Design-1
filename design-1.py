#Time Complexity : The time complexity is O(1) for all the operations ie add, remove and contains
#Space Complexity : The space complexity is O(M + K*N) M is the initial buck K is the number 
# of secondary bucket and N is number of primary bucket initialized
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : Faced error in some of the syntax and was confused in 
# writing the space complexity


#Your code here along with comments explaining your approach

class MyHashSet(object):

    def __init__(self):
        self.initialBucket=1000
        self.secondaryBucket=1000
        self.storage=[None]*self.initialBucket

    def hashfunc1(self,key):
        return key % self.initialBucket

    def hashfunc2(self,key):
        return key // self.secondaryBucket  

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.hashfunc1(key)
        internalBucket=self.hashfunc2(key)
        if self.storage[bucket]==None:
            if bucket==0:
                self.storage[bucket]=[False]*(self.secondaryBucket+1)
            else:
                self.storage[bucket]=[False]*self.secondaryBucket
        self.storage[bucket][internalBucket]=True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket=self.hashfunc1(key)
        internalBucket=self.hashfunc2(key)
        if self.storage[bucket]==None:
            return
        self.storage[bucket][internalBucket]=False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket=self.hashfunc1(key)
        internalBucket=self.hashfunc2(key)
        if self.storage[bucket]==None:
            return False
        return self.storage[bucket][internalBucket]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
