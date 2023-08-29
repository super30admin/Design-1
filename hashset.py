class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 1000  # Choose a suitable capacity for your HashSet
        self.data = [None] * self.capacity

    def _hash(self, key):
        return key % self.capacity

    def add(self, key):
        """
        Add a key to the HashSet.
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        if self.data[index] is None:
            self.data[index] = []
        if key not in self.data[index]:
            self.data[index].append(key)

    def remove(self, key):
        """
        Remove a key from the HashSet if it exists.
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        if self.data[index] is not None and key in self.data[index]:
            self.data[index].remove(key)

    def contains(self, key):
        """
        Check if the HashSet contains a key.
        :type key: int
        :rtype: bool
        """
        index = self._hash(key)
        return self.data[index] is not None and key in self.data[index]

# Example usage:
myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)
print(myHashSet.contains(1))  # Should return True
print(myHashSet.contains(3))  # Should return False
myHashSet.add(2)
print(myHashSet.contains(2))  # Should return True
myHashSet.remove(2)
print(myHashSet.contains(2))  # Should return False
