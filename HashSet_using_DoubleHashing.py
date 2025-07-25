#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 


#Your code here along with comments explaining your approach

class MyHashSet(object):

    def __init__(self):
        self.primaryBuckets=1001        #size of the primary bucket
        self.secondaryBuckets=1000      # size of the secondary bucket
        self.storage=[None]*self.primaryBuckets  # initilize the storage with primary buckets and all pointing to null 
    
    def hash1(self,key):                #first hash function to obtain the primarybucket index
        return key//self.primaryBuckets
    
    def hash2(self,key):                # second hash function to obtain the secondarybucket index
        return key%self.secondaryBuckets

        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryIndex=self.hash1(key)                #get the primarybucket index
        if self.storage[primaryIndex] is None:      #check if it is empty
            self.storage[primaryIndex]=[False]*self.secondaryBuckets  #initialize the secondarybucket if empty
        secondaryIndex=self.hash2(key)              #get the secondarybucket index
        self.storage[primaryIndex][secondaryIndex]=True #set the bucket value to true 

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryIndex=self.hash1(key)                  #get the primarybucket index
        if self.storage[primaryIndex] is None:         #check if it is empty just return
            return
        secondaryIndex=self.hash2(key)                 #get the secondarybucket index
        self.storage[primaryIndex][secondaryIndex]=False  #set the bucket value to false 
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primaryIndex=self.hash1(key)                     #get the primarybucket index
        if self.storage[primaryIndex] is None:           #check if it is empty return false indicating the element is not present
            return False
        secondaryIndex=self.hash2(key)                   #get the secondarybucket index
        return self.storage[primaryIndex][secondaryIndex] #return the value in the bucket which is true if the element is present 
        



        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)