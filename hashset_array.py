# // Time Complexity :O(1)
# // Space Complexity : O(n)=O(10^6) in worst case
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

# //so basically we created double array hashing hash set where 
# // when a key is given we first check to which bucket it will go and then to which bucketItem it will go

class MyHashSet:
    def __init__(self): 
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets #initialized to 1000 none size list
    
    def getBucket(self, key):
        return key % (self.buckets)
    
    def getBucketItem(self, key):
        return key // (self.bucketItems)
    
    def add(self, key):
        bucket = self.getBucket(key)
        bucketitem = self.getBucketItem(key)
        if self.storage[bucket] is None :
            if(bucket == 0):
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * (self.bucketItems)
        
        self.storage[bucket][bucketitem] = True
    
    def remove(self, key):
        bucket = self.getBucket(key)
        bucketitem = self.getBucketItem(key)
        if self.storage[bucket] is None :
            return
        self.storage[bucket][bucketitem] = False
    
    def contains(self, key):
        bucket = self.getBucket(key)
        bucketitem = self.getBucketItem(key)
        if self.storage[bucket] is None :
            return False
        return self.storage[bucket][bucketitem]
    


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(10)
obj.add(20)
obj.remove(10)
param_3 = obj.contains(10)
print(param_3)
    
    
    