"""
Time Complexity -> O(1) in most cases except during rehashing. But amortised to O(1)
Space Complexity ->O(n) where n is the number of elements

Approach:
Initially created an array of 1000001 as per constraint but wasnt space efficient.
New approach -> Dynamic rehashing with linear probing
"""

class MyHashSet:

    def __init__(self):
        self.capacity = 1000
        self.threshold = 0.75
        self.size = 0
        self.remove_tag = "DELETED"
        self.set = [None] * self.capacity

    def hash(self, key):
        return key % self.capacity

    def rehash(self):
        old_set = self.set
        self.size = 0
        self.capacity = 2 * self.capacity
        self.set = [None] * self.capacity
        # Add keys to newly initialised set
        for elem in old_set:
            if elem is not None and elem != self.remove_tag:
                self.add(elem)

    def add(self, key: int) -> None:
        # check if rehashing should be done
        if self.size / self.capacity >= self.threshold:
            self.rehash()
        index = self.hash(key)
        # check if index is already occupied or not. If occupied
        # find the next available position
        while self.set[index] is not None:
            if self.set[index] == key:
                return
            index = (index + 1) % self.capacity
        self.set[index] = key
        self.size += 1

    def remove(self, key: int) -> None:
        index = self.hash(key)
        start = index
        """
        Check if key is present in index. If the index is already occupied, perform 
        linear probing and find if the key can be found
        """
        while self.set[index] is not None:
            if self.set[index] == key:
                self.set[index] = self.remove_tag
                self.size -= 1
            index = (index + 1) % self.capacity
            if start == index:  # to prevent infinite looping
                return

    def contains(self, key: int) -> bool:
        index = self.hash(key)
        start = index
        while self.set[index] is not None:
            if self.set[index] == key:
                return True
            index = (index + 1) % self.capacity
            if start == index:  # to prevent infinite looping
                return False
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
