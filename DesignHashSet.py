# Time Complexity :O(1) for all functions
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : code to initialize 2D array in Python




class MyHashSet:
    
    

    def __init__(self):
        self.bucket=1000
        self.bucketItems=1000
        self.storage=[None]*self.bucket
    
    def getBucket(self,key: int) -> None:
        return key % self.bucket
    
    def getBucketItems(self,key: int) -> None:
        return key // self.bucketItems
        
        
        

    def add(self, key: int) -> None:
        bucketNo=self.getBucket(key)
        bucketItemsNo=self.getBucketItems(key)
        if self.storage[bucketNo]==None and bucketNo==0:
            self.storage[bucketNo]=[False]*(self.bucketItems+1)
        elif not self.storage[bucketNo]: 
            self.storage[bucketNo]=[False]*(self.bucketItems)
        self.storage[bucketNo][bucketItemsNo]=True 
    
    
                
        

    def remove(self, key: int) -> None:
        bucketNo=self.getBucket(key)
        bucketItemsNo=self.getBucketItems(key)
        if self.storage[bucketNo]==None:
            return 
        self.storage[bucketNo][bucketItemsNo]=False
        

    def contains(self, key: int) -> bool:
        bucketNo=self.getBucket(key)
        bucketItemsNo=self.getBucketItems(key)
        if self.storage[bucketNo]==None:
            return False
        
        return self.storage[bucketNo][bucketItemsNo]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
