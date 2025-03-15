# Hashset using Double Hashing Concept for collisions.
# TC: O(1) each method is using constant time since they perform a fixed number of array lookups
# SC:
# 1) Best case (no elements inserted): O(1) (Only the primary array exists, all None)
# 2) Average case: O(N) O(N) (Only necessary secondary arrays are allocated)
# 3) Worst case (all 1,000,000 elements stored): O(10^6) or O(N)


class MyHashSet:
    def __init__(self):
        self.primaryBuckets = 1000  # size of a Primary Ds should be based on the input range(sqrt of 10^6)
        self.secondaryBuckets = 1000
        self.storage = [None] * self.primaryBuckets

    # two hashFunc: one for primary DS (Array of integers) and the second for secondary DS (integer Array)
    def getPrimaryHash(
        self, key
    ):  # inorder to map all the inputs we need relevant hash function hence the % func.
        return key % self.primaryBuckets

    # to handle the collisions
    def getSecondaryHash(self, key):
        return key // self.primaryBuckets

    # add func simply checks if the primary DS isn't none and then adds the key meanwhile handling the edge case
    def add(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            if primaryIndex == 0:
                # +1 to handle key = 1000000
                self.storage[primaryIndex] = [False] * (self.secondaryBuckets + 1)
            else:
                self.storage[primaryIndex] = [False] * self.secondaryBuckets
        secondaryIndex = self.getSecondaryHash(key)  # assign sec. DS
        self.storage[primaryIndex][secondaryIndex] = True  # add the key

    def remove(self, key):
        primaryIndex = self.getPrimaryHash(key)  # get the primaryIndex
        if self.storage[primaryIndex] is not None:
            secondaryIndex = self.getSecondaryHash(key)  # get the secIndex
            self.storage[primaryIndex][secondaryIndex] = False  # mark it false if exist

    # same logic as remove only diff return key if exist else false
    def contains(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is not None:
            secondaryIndex = self.getSecondaryHash(key)
            return self.storage[primaryIndex][secondaryIndex]
        return False


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(1000000)  # Edge case
print(obj.contains(1))  # True
print(obj.contains(1000000))  # True
obj.remove(1)
print(obj.contains(1))  # False
