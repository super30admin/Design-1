# Time Complexity : O(n/k) for all operations, where n is the number of keys and k is the number of buckets.
# Space Complexity : O(n) where n is the number of keys present in the hashset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Uses a simple hashing function using a modulo operation to obtain a bucket from the given key
# I also use a linear chaining method and store the values in each bucket within an arraylist.


class MyHashSet:

    def __init__(self):
        self.numBuckets = 1000
        self.buckets = [[] for _ in range(self.numBuckets)]

    def add(self, key: int) -> None:
        b = self._bucket(key)
        if key not in b:
            b.append(key)

    def remove(self, key: int) -> None:
        b = self._bucket(key)
        if key in b:
            b.remove(key)

    def contains(self, key: int) -> bool:
        return key in self._bucket(key)

    def _bucket(self, key: int):
        return self.buckets[key % self.numBuckets]
