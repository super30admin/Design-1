#  Time Complexity : O(1) for add, remove, contains.
#  Space Complexity : O ( buckets * bucket_items) where bucket and bucket_items is the storage size.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No 

# Approach: Double Hashing. First Hash Function: key % (10^3) Second Hash Function: key // (10^ 3)
# Given the range 0 - 10^6, we consider sqrt(10^6) = 10^3 to cleverly choose the key for hashing.  

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucket_items = 1001
        self.storage = [False for _ in range(self.buckets)]

    def _get_bucket(self, key):
        return key % 1000
    
    def _get_bucket_item(self, key):
        return key // 1000

    def add(self, key: int) -> None:
        bucket = self._get_bucket(key)
        bucket_item = self._get_bucket_item(key)
        if not self.storage[bucket]:
            bucket_items_range = self.bucket_items if bucket == 0 else (self.bucket_items + 1)
            self.storage[bucket] = [False for _ in range(bucket_items_range)]
        self.storage[bucket][bucket_item] = True
        

    def remove(self, key: int) -> None:
        bucket = self._get_bucket(key)
        bucket_item = self._get_bucket_item(key)
        if self.storage[bucket]:
            self.storage[bucket][bucket_item] = False

    def contains(self, key: int) -> bool:
        bucket = self._get_bucket(key)
        bucket_item = self._get_bucket_item(key)
        if self.storage[bucket]:
            return self.storage[bucket][bucket_item]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
