"""
This implementation uses a chaining approach with a fixed-size array of buckets to handle collisions.
Each bucket is a list that stores elements that hash to the same index, allowing for efficient O(1) average case operations.
The hash function uses modulo operation to map keys to bucket indices, and the implementation handles add, remove, and contains operations with proper collision management.
"""

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        # Initialize with 1000 buckets to start with
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key: int) -> int:
        # Simple hash function using modulo
        return key % self.size

    def add(self, key: int) -> None:
        # Get the bucket index
        bucket_idx = self._hash(key)
        # If key doesn't exist in the bucket, add it
        if key not in self.buckets[bucket_idx]:
            self.buckets[bucket_idx].append(key)

    def remove(self, key: int) -> None:
        # Get the bucket index
        bucket_idx = self._hash(key)
        # Remove the key if it exists in the bucket
        if key in self.buckets[bucket_idx]:
            self.buckets[bucket_idx].remove(key)

    def contains(self, key: int) -> bool:
        # Get the bucket index
        bucket_idx = self._hash(key)
        # Check if key exists in the bucket
        return key in self.buckets[bucket_idx]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)