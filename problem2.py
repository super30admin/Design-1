class MyHashSet:

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1001  # 1001 to handle keys up to 10^6
        self.storage = [None] * self.primaryBuckets  # Initialize primary buckets

    def _getPrimaryHash(self, key):
        return key % self.primaryBuckets

    def _getSecondaryHash(self, key):
        return key // self.secondaryBuckets

    def add(self, key):
        primaryIndex = self._getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            self.storage[primaryIndex] = [False] * self.secondaryBuckets  # Initialize secondary array
        secondaryIndex = self._getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key):
        primaryIndex = self._getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return
        secondaryIndex = self._getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key):
        primaryIndex = self._getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return False
        secondaryIndex = self._getSecondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex]  # Fixed this line!

# Example usage:
# obj = MyHashSet()
# obj.add(1)
# obj.add(2)
# print(obj.contains(1))  # True
# print(obj.contains(3))  # False
# obj.remove(2)
# print(obj.contains(2))  # False
