class MyHashSet:
    def __init__(self):
        # Number of primary and secondary buckets
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        # Initialize storage with None for lazy allocation
        self.storage = [None] * self.primaryBuckets

    def getPrimaryHash(self, key):
        # Hash function for primary bucket
        return key % self.primaryBuckets

    def getSecondaryHash(self, key):
        # Hash function for secondary bucket
        return key // self.secondaryBuckets

    def add(self, key):
        # Add a key to the HashSet
        primaryIndex = self.getPrimaryHash(key)
        # Lazy initialization of secondary bucket
        if self.storage[primaryIndex] is None:
            # Handle edge case for maximum key value
            if primaryIndex == 0:
                self.storage[primaryIndex] = [False] * (self.secondaryBuckets + 1)
            else:
                self.storage[primaryIndex] = [False] * self.secondaryBuckets
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key):
        # Remove a key from the HashSet
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key):
        # Check if a key exists in the HashSet
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return False
        secondaryIndex = self.getSecondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex]

#Time Complexity:
# - add: O(1)   
# - remove: O(1)
# - contains: O(1)
# Space Complexity:
# - O(n) 
