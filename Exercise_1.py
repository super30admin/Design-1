# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        # implementing using double hashing
        # storing 10^6 elements in 10^3 buckets and each bucket stores 10^3 items
        self.buckets = 1000
        self.bucket_items = 1000
        self.storage = [None] * self.buckets

    def get_bucket(self, key):
        return key % self.buckets

    def get_bucket_item(self, key):
        return key // self.bucket_items


    def add(self, key: int) -> None:
        bucket = self.get_bucket(key)
        if self.storage[bucket] is None:
            # edge case where 10^6 needs to be added, assign 10^3 + 1 spaces
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucket_items+1)
            else:
                self.storage[bucket] = [False] * self.bucket_items
        # look for key in bucket items, and add element 
        bucket_item = self.get_bucket_item(key)
        self.storage[bucket][bucket_item] = True
        

    def remove(self, key: int) -> None:
        bucket = self.get_bucket(key)
        if self.storage[bucket] is None:
            return

        bucket_item = self.get_bucket_item(key)
        self.storage[bucket][bucket_item] = False
        
        

    def contains(self, key: int) -> bool:
        bucket = self.get_bucket(key)
        if self.storage[bucket] is None:
            return False

        bucket_item = self.get_bucket_item(key)
        return self.storage[bucket][bucket_item]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)