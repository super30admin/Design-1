# Time Complexity : 0(1)
# Space Complexity : 
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : Matrix creation 
# Your code here along with comments explaining your approach



class MyHashSet:
    def __init__(self):
        self.bucket_count = 1000
        self.bucket_item_count = 1000
        self.storage = [[False] * self.bucket_item_count for _ in range(self.bucket_count)]

    def hash1(self, key):
        return key % self.bucket_count

    def hash2(self, key):
        return key // self.bucket_count

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucket_item = self.hash2(key)
        if self.storage[bucket] is None:
            self.storage[bucket] = [False] * self.bucket_item_count
        self.storage[bucket][bucket_item] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucket_item = self.hash2(key)
        if self.storage[bucket] is not None:
            self.storage[bucket][bucket_item] = False

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucket_item = self.hash2(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucket_item]


