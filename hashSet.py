// Time Complexity : O(1)
// Space Complexity : O(N) here array size is N = 10^6
// Did this code successfully run on Leet code : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
	# Initialize primary array called bucket and its subset for each bucket as bucketItems
        self.buckets =1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets # All bucket are initialized to None
    
    def getBucket(self, key: int) -> int:
	# find index location
        return key % self.buckets
    
    def getBucketItem(self, key: int) -> int:
	# find index location
        return key // self.bucketItems
    
    def add(self, key: int) -> None:
	# Calculate bucket and bucketItem for a given key
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem (key)
	# If the bucket is empty (None), create a new list to store elements in the bucket
        if self.storage[bucket] == None:
	 # For the first bucket (bucket index 0), add an additional slot to handle bucketItems 0 to 999
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItems
        # Set the bucket item to True to indicate the presence of the element
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
	# Calculate bucket and bucketItem for a given key
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem (key)
	# If the bucket is empty (None), return as the element is not present
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = True

    def contains(self, key: int) -> bool:
 	# Calculate bucket and bucketItem for a given key
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem (key)
	# If the bucket is empty (None), the element is not present in the hash set
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem] == True
        

# My MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(key)
obj.remove(key)
param_3 = obj.contains(key)
