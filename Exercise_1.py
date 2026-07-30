# Design HashSet
# https://leetcode.com/problems/design-hashset/description/

# Time complexity: O(1)
# Space complexity: O(n)

# Uses double hashing - primary hash to find which bucket, secondary hash to find position in bucket;
# also uses boolean values instead of int to save space - works well here because this is a set and the operations only require "check if exisits" operations

class MyHashSet:

    def __init__(self):
        self.primary_buckets = 1000
        self.secondary_buckets = 1001

        # Each primary bucket is initialized only when needed.
        self.storage = [None] * self.primary_buckets

    def _primary_hash(self, key: int) -> int:
        return key % self.primary_buckets

    def _secondary_hash(self, key: int) -> int:
        return key // self.primary_buckets

    def add(self, key: int) -> None:
        primary_index = self._primary_hash(key)
        secondary_index = self._secondary_hash(key)

        if self.storage[primary_index] is None:
            self.storage[primary_index] = [False] * self.secondary_buckets

        self.storage[primary_index][secondary_index] = True

    def remove(self, key: int) -> None:
        primary_index = self._primary_hash(key)

        if self.storage[primary_index] is None:
            return

        secondary_index = self._secondary_hash(key)
        self.storage[primary_index][secondary_index] = False

    def contains(self, key: int) -> bool:
        primary_index = self._primary_hash(key)

        if self.storage[primary_index] is None:
            return False

        secondary_index = self._secondary_hash(key)
        return self.storage[primary_index][secondary_index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
