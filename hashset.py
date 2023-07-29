#Time Complexity:- O(1)
#Space Complexity:-O(N)

class MyHashSet:

    def __init__(self):
        # Intializing the number of bucket and bucket items
        self.buckets=1000
        self.bucketItems=1000
        # Create a list to represent the hash set storage, all buckets are initially set to None
        self.storage=[None]*self.buckets

    def getBucket(self,key:int)->int:
        return key%self.buckets 

    def getBucketItems(self,key:int)->int:
        return key//self.bucketItems

    def add(self, key: int) -> None:
        # Calculate the bucket and bucket item for the given key
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)
        
        # If the bucket is empty (None), create a new list to store elements in the bucket
        if self.storage[bucket] == None:
            if bucket ==0:
                 # For the first bucket (bucket index 0), add an additional slot to handle bucketItems 0 to 999
                self.storage[bucket] = [None] *(self.bucketItems + 1)
            else:
                # For other buckets, create a list with bucketItems slots (0 to 999)
                self.storage[bucket] = [None] * self.bucketItems
        # Set the bucket item to True to indicate the presence of the element
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
         # Calculate the bucket and bucket item for the given key
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        
        # If the bucket is empty (None), return as the element is not present
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItems]=None
        
    def contains(self, key: int) -> bool:
         # Calculate the bucket and bucket item for the given key
        bucket=self.getBucket(key)
        bucketItems=self.getBucketItems(key)
        # If the bucket is empty (None), the element is not present in the hash set
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItems] is not None
