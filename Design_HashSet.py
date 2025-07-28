class MyHashSet:
    # Time Complexity: O(1) for all operations (add, remove, contains)
    # Space Complexity: O(n)
    # Ran successfully on Leetcode: Yes
    # Faced any issues: Nope, the approach made more sense after it was explained in class

    def __init__(self):
        # Using double hashing with a 2-dimensional boolean array
        self.primaryBucket = 1000
        self.secondaryBucket = 1000
        self.storage = [None] * self.primaryBucket

    def get_primaryHash(self, key):
        # Calculating primary hash function which gives index in storage array
        return key % self.primaryBucket

    def get_secondaryHash(self, key):
        # Calculating secondary hash function which gives index in storage[primaryBucket] array
        return key // self.secondaryBucket

    def add(self, key: int) -> None:
        # Calculating both hash function and marking value True in 2D array
        primaryHash = self.get_primaryHash(key)
        secondaryHash = self.get_secondaryHash(key)
        if self.storage[primaryHash] is None:
            # Need to initialize one extra space in secondary bucket to accomodate 1000000 since 1000000 // 1000 = 1000
            if primaryHash == 0:
                self.storage[primaryHash] = [False] * (self.secondaryBucket + 1)
            else:
                self.storage[primaryHash] = [False] * self.secondaryBucket
        self.storage[primaryHash][secondaryHash] = True

    def remove(self, key: int) -> None:
        # Setting value as False where element might exist as False to remove element from array
        primaryHash = self.get_primaryHash(key)
        secondaryHash = self.get_secondaryHash(key)
        if self.storage[primaryHash] is not None:
            self.storage[primaryHash][secondaryHash] = False

    def contains(self, key: int) -> bool:
        # Seeing if element exist in calculated location or not
        primaryHash = self.get_primaryHash(key)
        secondaryHash = self.get_secondaryHash(key)
        return self.storage[primaryHash] is not None and self.storage[primaryHash][secondaryHash]
