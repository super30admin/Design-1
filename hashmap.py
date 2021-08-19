# // Time Complexity : O(1) for each function call made to MyHashMap class functions
# // Space Complexity : O(n) where n is the number of elements stored in the hashmap  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : missed thh edge case where key could be 10^6


# // Your code here along with comments explaining your approach

class MyHashMap:

def __init__(self):
    """
    Initialize your data structure here.
    """
    self.arr = [None for i in range(1000)]
    self.bucket = 1000
    self.bucketItem = 1000

def getBucket(self, key):
    return key % self.bucket

def getBucketItem(self, key):
    return key // self.bucketItem

def put(self, key: int, val: int) -> None:
    """
    value will always be non-negative.
    """
    # function to calcualte the hash for the key
    bucket = self.getBucket(key)
    # double hashing to keep a smaller storage size
    bucketItem = self.getBucketItem(key)
    
    if self.arr[bucket] == None:
        if bucket == 0:
            self.arr[bucket] = [None for i in range(1001)]
        else:
            self.arr[bucket] = [None for i in range(1000)]
    self.arr[bucket][bucketItem] = (key,val)
        
        
def get(self, key: int) -> int:
    """
    Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    """
    bucket = self.getBucket(key)
    bucketItem = self.getBucketItem(key)
    # if the key, val pair is found, it is returned else we get None and -1 is returned
    if self.arr[bucket] and self.arr[bucket][bucketItem]:
        return self.arr[bucket][bucketItem][1]
    else:
        return -1

def remove(self, key: int) -> None:
    """
    Removes the mapping of the specified value key if this map contains a mapping for the key
    """
    bucket = self.getBucket(key)
    bucketItem = self.getBucketItem(key)
    if self.arr[bucket] and self.arr[bucket][bucketItem]:
        self.arr[bucket][bucketItem] = None
    