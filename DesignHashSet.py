'''
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
class MyHashSet(object):

    def __init__(self):
        #Primary list len
        self.buckets=1000
        
        #Secondary List len
        self.bucketItems=1000
        
        #Primary list
        self.table=[None]*self.buckets
        
    #Hash function to check the index into the primary list
    def hash_function1(self,key):
        return key % self.buckets
    
    #Hash function to check the index into the secondary list
    def hash_fucntion2(self,key):
        return key/self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #Get primary index
        bucket_val=self.hash_function1(key)
        
        #Get secondary index
        buckectItems_val=self.hash_fucntion2(key)
        
        #If secondary list exists and if the element is not already present then set the secondary index to True
        if self.table[bucket_val] is not None:
            if self.contains(key)==False:
                self.table[bucket_val][buckectItems_val]=True
        #Else create a secondary list and then set the element as True
        else:
            #Handling the edge case
            if(bucket_val==0):
                self.table[bucket_val]=[False]*(self.bucketItems+1)
                self.table[bucket_val][buckectItems_val]=True
            else:
                self.table[bucket_val]=[False]*self.bucketItems
                self.table[bucket_val][buckectItems_val]=True
            
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_val=self.hash_function1(key)
        buckectItems_val=self.hash_fucntion2(key)
        #Check if the element is present(location if true) and set it to false
        if self.table[bucket_val] is not None:
            if self.table[bucket_val][buckectItems_val]==True:
                self.table[bucket_val][buckectItems_val]=False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket_val=self.hash_function1(key)
        buckectItems_val=self.hash_fucntion2(key)
        if self.table[bucket_val] is None:
            return False
        else:
            return self.table[bucket_val][buckectItems_val]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
