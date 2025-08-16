# Problem 1 - Design HashSet (https://leetcode.com/problems/design-hashset/)
# Implemented a hash set using two-level array to handle large key ranges efficiently
# First hash function finds primary bucket and second hash function finds index inside that bucket
# To save space, secondary arrays are initialized only when needed, and a special case for bucket 0 handles maximum key edge case (10^6)
class MyHashSet:

    def __init__(self):
        self.buckets = 1000 # primary arr size
        self.bucketItems = 1000 # secondary arr size
        self.storage = [None] * self.buckets # primary arr

    def hash1(self, key: int) -> int:
        return key % self.buckets

    def hash2(self, key: int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[bucket] == None:
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