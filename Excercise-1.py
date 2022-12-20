# Approch:- Used a 2D list of size 1000 to create HashSet,each element containing list of elements mapped from Hash Function.
# Time Complexity : O(1) for lookup,insertion,remove
# Space Complexity :O(n) #For HashSet
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No



class MyHashSet(object):

    def __init__(self):
        self.HashSet=[[] for i in range (1000)]

    def Hash_Function(self,key):
        return(key%1000)  

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.HashSet[self.Hash_Function(key)].append(key)
        
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hv=self.Hash_Function(key)
        if(self.HashSet[hv] !=[]):
            while(key in self.HashSet[hv]):
                self.HashSet[hv].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hv=self.Hash_Function(key)
        if(self.HashSet[hv] !=[]):
            if(key in self.HashSet[hv]):
                return(True)
        return(False)
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)