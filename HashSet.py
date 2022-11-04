"""
    Problem Statement: Design a Hash Set.

    Approach: Presumably define the size of the HashSet to be close to square root of the range if not exact.
              Use double hashing technique with modulus and divide operators to get the index of primary and 
              secondary indices respectively.

    Time complexity:
    getBucket(): O(1)
    getBucketItem(): O(1)
    add(): O(1)
    remove(): O(1)
    contains(): O(1)
    
    Space complexity: O(n), where n is the length of the array.

    Working on LeetCode? Yes!
"""
import random
from typing import List, Optional

class HashSet:
    size = 10 ** 3
    def __init__(self):
        """Initialize the buckets"""
        self.buckets: List[Optional[List]] = [None] * self.size

    def getBucket(key) -> int:
        """Hash function to get the index of primary array"""
        return key % HashSet.size 

    def getBucketItem(key) -> int:
        """Hash function to get the index of secondary array"""
        return key // HashSet.size

    def add(self, key: int) -> None:
        """Add an element in the HashSet"""
        bucket: int = HashSet.getBucket(key)
        bucketItem: int = HashSet.getBucketItem(key)

        if not self.buckets[bucket]:
            if not bucket:
                self.buckets[bucket]: List[bool] = [None] * (HashSet.size + 1)
            else:
                self.buckets[bucket]: List[bool] = [None] * HashSet.size

        self.buckets[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        """Remove element from HashSet"""
        bucket: int = HashSet.getBucket(key)
        bucketItem: int = HashSet.getBucketItem(key)
        
        if not self.buckets[bucket]:
            return

        self.buckets[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        """Return boolean is key present in HashSet"""
        bucket: int = HashSet.getBucket(key)
        bucketItem: int = HashSet.getBucketItem(key)
        
        if not self.buckets[bucket]:
            return False

        return self.buckets[bucket][bucketItem]

if __name__ == "__main__":
    hashset = HashSet()

    hashset.add(1)
    hashset.add(2)
    hashset.add(3)
    hashset.add(4)
    hashset.add(5)
    
    assert hashset.contains(6) == False
    hashset.remove(2)
    assert hashset.contains(2) == False