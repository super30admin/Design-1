"""
# Time Complexity :
Adding an element: O(1) on average, O(K) in worst case where K is the length of the longest chain formed which needs to be iterated

Removing an element: O(1) on average, O(K) in worst case where K is the length of the longest chain formed which needs to be iterated

Checking for an element: O(1) on average, O(K) in worst case where K is the length of the longest chain formed which needs to be iterated

# Space Complexity : O(N + M), where N is the number of buckets (1000 in this case) and M is the number of elements stored in the hash set

# Did this code successfully run on Leetcode :

Yes, much faster than 2-D Addressing

# Any problem you faced while coding this :
    - still rusty with list comprehensions after switching from C++ to Python

"""


#Approach 2 (Optimized) - Separate Chaining using Python lists

#Explanation (within 3 lines) - Made use of a primary array of buckets, each of which hold a list of elements which 
# are present within the bucket in case a collision occurs.

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.arr = [[] for _ in range(self.buckets)] #each bucket is an empty list, initially
    
    def getBucket(self, key):
        return key % self.buckets
        
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)

        if key not in self.arr[bucket]:
            self.arr[bucket].append(key)
     

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        
        if key in self.arr[bucket]:
            self.arr[bucket].remove(key)
        

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)

        return  key in self.arr[bucket]

"""

Approach 1 - Direct Addressing in 2-D Array


# Time Complexity :
Adding an element: O(1)
Removing an element: O(1)
Checking for an element: O(1)


# Space Complexity : O(N^2), where N is the total bucket count (1000 in this case)

# Did this code successfully run on Leetcode :
    - yes, with much slower performance than separate chaining. However it is prone to indexing errors with larger keys (like how we needed to handle 10^6 manually). We are also allocating a large amount of space that may not be fully used.

# Any problem you faced while coding this :
    - still rusty with list comprehensions after switching from C++ to Python
    - having trouble analysing null behavior in secondary array
    - this approach with secondary array was much slower than using separate chaining with list


class MyHashSet:

    def __init__(self):
        self.buckets = 1000 #initialized basis sqrt of max input size
        # self.arr = [[False] * self.buckets] * self.buckets - NEED TO HANDLE CASE WHERE input is 10^6
        self.arr = [[False] * (self.buckets + 1) if _ == 0 else [False] * self.buckets for _ in range(self.buckets)]
    
    def getBucket(self, key):
        return key % self.buckets #modulo keeps index within bucket count
    
    def getBucketItem(self, bucket, key):
        secHashValue = key // self.buckets #performing integer division to get secondary array index
        return secHashValue
        

    #the remaining functions are now fairly lightweight because they can simply call getBucket and getBucketItems

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(bucket, key)

        self.arr[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(bucket, key)
        self.arr[bucket][bucketItem] = False


    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(bucket, key)
        return self.arr[bucket][bucketItem]

        
"""

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
