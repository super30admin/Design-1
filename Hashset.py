# Time Complexity : O(1) to access
# Space Complexity : Worst case 10^6
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Learnt 
# about array declaration to save space


# Your code here along with comments explaining your approach

class MyHashSet:
    
    
    def __init__(self):
        # Buckets and Bucket Items
        self.buckets = 1000
        self.bucketitems = 1000
        # Defining a hashmap
        self.storage = [[]]*1000
    # Helper functions defining Hashing 
    def getBucket(self, key):
        return key%self.buckets
    
    def getBucketItem(self, key):
        return key//self.bucketitems

    # Add the bool value into the hashset
    # Also considering the case for bucket 0
    def add(self, key:int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if (self.storage[bucket] == []):
            if bucket == 0:
                self.storage[bucket] = [False]*1001
            else:
                self.storage[bucket] = [False]*1000
        self.storage[bucket][bucketItem] = True
        print(self.storage[bucket][bucketItem])
    
    # For removal simply set the value
    #  at index to be Null or False
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if (self.storage[bucket] == []):
            return
        self.storage[bucket][bucketItem] = None

    # For checking if the value is present or not
    # Access is in O(1)  
    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if (self.storage[bucket] == []):
            return False
        return self.storage[bucket][bucketItem]
    
    
    
    
        
        
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)