# Time Complexity : O(1) avg
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Bucket 0 needs size 1001 for key = 1_000_000


# Your code here along with comments explaining your approach


class MyHashSet:

    def __init__(self):
        self.primaryBuckets = 1000 # number of outer buckets
        self.secondaryBuckets = 1000 # size of inner buckets (except bucket 0)
        self.storage = [None] * self.primaryBuckets

    def getPrimaryHash(self, key):
        return key % self.primaryBuckets # maps to [0..999]

    def getSecondaryHash(self, key):
        return key // self.secondaryBuckets # maps to [0..1000]

    def add(self, key: int) -> None:

        # Find the primary bucket for this key

        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            if primaryIndex == 0:
                # Bucket 0 needs one extra slot (index 1000) to hold key = 1_000_000
                self.storage[primaryIndex] = [False] * (self.secondaryBuckets + 1)
            else:
                # All other buckets are of length 1000 (indices 0..999)
                self.storage[primaryIndex] = [False] * self.secondaryBuckets

        # Compute the position within the secondary bucket and mark presence
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key: int) -> None:
        # Locate the primary bucket; if unallocated, the key cannot be present
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return

        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key: int) -> bool:
        # If the primary bucket was never allocated, the key isn't present
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return False

        # Return the presence flag from the appropriate slot
        secondaryIndex = self.getSecondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)