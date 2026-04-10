#// Time Complexity : Averge of O(1) unless everything ends up in one bucket.
#// Space Complexity : O(N)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : Add difficulty in converting add function concept to code.

#// Your code here along with comments explaining your approach
#Treating every number as a grid coordinate -> 2D (double hashing)
#Create the secondary bucket values when needed instead of ccreating at start
#Using boolean switch insted of actual values(True/false).

class MyHashSet(object):

    def __init__(self):
        self.bucket = 1000
        self.items_per_bucket = 1000
        self.storage = [None] * self.bucket

    def primary_hash(self,key):
        return key % self.bucket
    
    def secondary_hash(self,key):
        return key //self.items_per_bucket
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index = self.primary_hash(key)
        secondary_index = self.secondary_hash(key)

        if self.storage[primary_index] is None:
            if primary_index == 0:
                size = self.items_per_bucket + 1
            else:
                size = self.items_per_bucket
            self.storage[primary_index] = [False] * size
        self.storage[primary_index][secondary_index] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index = self.primary_hash(key)
        secondary_index = self.secondary_hash(key)

        #if bucket exist then only the key
        if self.storage[primary_index] is not None:
            self.storage[primary_index][secondary_index] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primary_index = self.primary_hash(key)
        secondary_index = self.secondary_hash(key)

        return self.storage[primary_index] is not None and self.storage[primary_index][secondary_index]



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
