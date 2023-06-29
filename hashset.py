

# Code Successfully ran on Leetcode, Please refer Readme.md for Runtime Analysis

class MyHashSet:

    def __init__(self, size: int = None):
        self._max = 1000 if size is None else size
        self._a = [None] * self._max

    def hash_function(self, key: int) -> (int, int):
        """
        Hashes the Given key and returns the hashing keys
        :param key:
        :return: tuple of two hashing keys
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        return key % self._max, key // self._max

    def add(self, key: int) -> None:
        """
        Add an element to the hash set
        :param key:
        :return: None
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        (hash1, hash2) = self.hash_function(key)
        if not self._a[hash1]:
            self._a[hash1] = [None] * (self._max + 1)
        self._a[hash1][hash2] = True

    def remove(self, key: int) -> None:
        """
        Remove a key from hashset(aka set in python)
        :param key:
        :return:
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        (hash1, hash2) = self.hash_function(key)
        if self._a[hash1] is None:
            return
        if self._a[hash1][hash2] is None:
            return
        self._a[hash1][hash2] = None

    def contains(self, key: int) -> bool:
        """
        Check if the given key is in the HashSet
        :param key:
        :return: True/False
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        (hash1, hash2) = self.hash_function(key)
        if self._a[hash1] is None:
            return False
        if self._a[hash1][hash2] is None:
            return False
        return True


# Your MyHashSet object will be instantiated and called as such:
if __name__ == "__main__":
    obj = MyHashSet()
    obj.add(9)
    obj.add(1000)
    obj.remove(1000)
    param_3 = obj.contains(9)
