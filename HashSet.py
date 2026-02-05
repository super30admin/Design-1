# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : two level bucket structure (primary -> secondary) with boolean arrays for constant time access.

class MyHashSet:
    def __init__(self):
        self.primaryBucketSize = 1000
        self.secondaryBucketSize = 1000
        self.storage = [[] for _ in range(self.primaryBucketSize)]

    def getPrimaryHash(self, key: int) -> int:
        return key % self.primaryBucketSize

    def getSecondaryHash(self, key: int) -> int:
        return key // self.secondaryBucketSize

    def add(self, key: int) -> None:
        primaryHash = self.getPrimaryHash(key)
        if self.storage[primaryHash] == []:
            if primaryHash == 0:
                self.storage[primaryHash] = [False] * (self.secondaryBucketSize + 1) # handle division edge case for 10^6
            else:
                self.storage[primaryHash] = [False] * (self.secondaryBucketSize)

        secondaryHash = self.getSecondaryHash(key)
        self.storage[primaryHash][secondaryHash] = True

    def remove(self, key: int) -> None:
        primaryHash = self.getPrimaryHash(key)
        if self.storage[primaryHash] == []:
            return
        secondaryHash = self.getSecondaryHash(key)
        self.storage[primaryHash][secondaryHash] = False

    def contains(self, key: int) -> bool:
        primaryHash = self.getPrimaryHash(key)
        if not self.storage[primaryHash]:
            return False
        secondaryHash = self.getSecondaryHash(key)
        return self.storage[primaryHash][secondaryHash]