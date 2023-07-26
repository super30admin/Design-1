'''
1. Used 2 hash functions, one to generate bucket and one to generate bucket item
2. Since the maximum size is 10**6, we can use 1000 buckets and 1000 bucket items. But to access index 0,1000 we need the bucket size to be 1001(EDGE CASE)
3. A key exists if its value in the HashSet is True. If it is None, key doesnt exist in the set

Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

'''

class MyHashSet:

    def __init__(self):
        self.buckets = [None]*1000

    def getBucket(self,key):
        return key%1000
    
    def getBucketItem(self,key):
        return key//1000

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.buckets[bucket] is None:
            if bucket == 0:
                self.buckets[bucket] = [None]*1001
            else:
                self.buckets[bucket] = [None]*1000
        self.buckets[bucket][bucketItem] = True
            

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.buckets[bucket] is not None:
            self.buckets[bucket][bucketItem] = None

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.buckets[bucket] is not None:
            return self.buckets[bucket][bucketItem] is True
        else:
            return False