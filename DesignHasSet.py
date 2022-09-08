# Implement HashSet without using any built-in libraries.

# your design should include these functions:

# add(value): Insert a value into the HashSet. 
# contains(value) : Return whether the value exists in the HashSet or not.
# remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

## Time Complexity of add = O(1), remove = O(1), contains  = O(1)
## Passed in LeetCode


class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #Initialize the 
        self.hash_set = bytearray(1000001)
        self.size = 1000
        self.buckets = [None]*(self.size)
   
    def getBucket(self, key:int):
        return key %self.size
        
            
    def getBucketItems(self, key:int):
        return key//self.size
      
        
    def add(self, key: int) -> None:
        Bucket_key= self.getBucket(key)
        BucketItem_key = self.getBucketItems(key)
        if not self.buckets[Bucket_key]:
            if  Bucket_key==0: 
                self.buckets[Bucket_key]= [False]*(self.size+1)
            else:
                self.buckets[Bucket_key]=[False]*(self.size)
        self.buckets[Bucket_key][BucketItem_key]= True 
            

    def remove(self, key:int)-> None:
        Bucket_key= self.getBucket(key)
        BucketItem_key = self.getBucketItems(key)
        if self.buckets[Bucket_key] :
            self.buckets[Bucket_key][BucketItem_key] = False
       
       
         
    
    def contains(self, key: int) -> bool:
        Bucket_key= self.getBucket(key)
        BucketItem_key = self.getBucketItems(key)
        if self.buckets[Bucket_key]:
            return self.buckets[Bucket_key][BucketItem_key]
       
   
        # if self.buckets[Bucket_key][BucketItem_key] == True:
        #     return True
        
            






#Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

        





     








