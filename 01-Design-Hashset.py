# Problem 1: Design HashSet (https://leetcode.com/problems/design-hashset/)

# Time Complexity : O(1) for add, remove, and contains operations
# Space Complexity : O(n) where n is the number of unique keys added to the HashSet
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# We will use a 2D list (array of arrays) to implement the HashSet.
# The first hash function will determine the bucket (outer array index) and the second hash function
# will determine the position within that bucket (inner array index). 

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def hash1(self, key: int) -> int:
        return key % self.buckets

    def hash2(self, key: int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[bucket] == None:
            # Handle the special case for bucket 0 (to allow key=10^6)
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItems

        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)