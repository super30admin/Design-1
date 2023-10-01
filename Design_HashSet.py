# Time Complexity : O(1) for all methods (add, remove, contains)
# Space Complexity : O(1)
class MyHashSet:

    def __init__(self):
        self.buckets = 1000  # Define the size of the primary storage.
        self.storage = [None] * self.buckets  # Initialize primary storage with None.

    def _hashFirst(self, key: int) -> int:
        return key % 1000  # Compute primary index by taking modulo of key with the size of primary storage.

    def _hashSecond(self, key: int) -> int:
        return key // 1000  # Compute secondary index by performing integer division of key by the size of primary storage.

    def add(self, key: int) -> None:
        index1 = self._hashFirst(key)  # Get primary index.
        index2 = self._hashSecond(key)  # Get secondary index.

        # If primary bucket at index1 isn't initialized:
        if not self.storage[index1]:
            # Special case: for key 0-999, we need an array of size 1001.
            if index1 == 0:
                self.storage[0] = [False] * 1001
            else:
                self.storage[index1] = [False] * 1000  # Otherwise, initialize an array of size 1000.

        # Mark the position indicating the key exists.
        self.storage[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self._hashFirst(key)  # Get primary index.
        index2 = self._hashSecond(key)  # Get secondary index.

        # If the primary bucket is initialized, mark the key as removed.
        if self.storage[index1]:
            self.storage[index1][index2] = False

    def contains(self, key: int) -> bool:
        index1 = self._hashFirst(key)  # Get primary index.
        index2 = self._hashSecond(key)  # Get secondary index.

        # Return True if the key is in the hashset, otherwise return False.
        return self.storage[index1] and self.storage[index1][index2]
