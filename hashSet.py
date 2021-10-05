# Time Complexity: Insertion O(1) Search O(1)
# Space Complexity: O(n)
# Ran Successfully on Leetcode - 226 ms

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashset = [None] * 100000

    def hashing(self, key):
        return key % 10000

    def add(self, key: int) -> None:
        hv = self.hashing(key)
        if self.hashset[hv] == None:
            self.hashset[hv] = [key]
        else:
            self.hashset[hv].append(key)

    def remove(self, key: int) -> None:
        hv = self.hashing(key)
        if self.hashset[hv] != None:
            while key in self.hashset[hv]:
                self.hashset[hv].remove(key)

    def contains(self, key: int) -> bool:

        hv = self.hashing(key)
        if self.hashset[hv] != None:
            if key in self.hashset[hv]:
                return True
            else:
                return False
