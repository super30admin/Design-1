#  Time Complexity :
#  - add: O(1) amortized (constant time hashing and possible one-time bucket allocation)
#  - remove: O(1) (constant time access)
#  - contains: O(1) (constant time access)

#  Space Complexity :
#  - O(m) amortized, where m = number of unique keys inserted (due to lazy allocation of buckets)
#  - Worst case O(1,000,000) if all possible keys in range [0, 10^6] are added.

#  Did this code successfully run on Leetcode : Yes

#  Approach###
#  Used double hashing to simulate a hash set with O(1) average time for add, remove, and contains operations.
#  The outer array (buckets) maps to an inner boolean array allocated lazily on demand to save space.
#  The first hash determines which bucket to use, the second hash determines the position inside that bucket.
#  This approach handles keys up to 10^6 efficiently with space optimization.class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets  # Only outer array initialized

    def _hash1(self, key: int) -> int:
        return key % self.buckets

    def _hash2(self, key: int) -> int:
        return key  self.bucketItems

    def add(self, key: int) -> None:
        i = self._hash1(key)
        j = self._hash2(key)
        if self.storage[i] is None:
            # Handle 10^6 edge case: need 1001 items in storage[0]
            if i == 0:
                self.storage[i] = [False] * (self.bucketItems + 1)
            else:
                self.storage[i] = [False] * self.bucketItems
        self.storage[i][j] = True

    def remove(self, key: int) -> None:
        i = self._hash1(key)
        j = self._hash2(key)
        if self.storage[i] is not None:
            self.storage[i][j] = False

    def contains(self, key: int) -> bool:
        i = self._hash1(key)
        j = self._hash2(key)
        if self.storage[i] is None:
            return False
        return self.storage[i][j]
