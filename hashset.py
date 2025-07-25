# Time Complexity : O(1) for all operations
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No
# Using double hahing approach

class MyHashSet(object):
    def __init__(self):
        self.primarySet = 1000
        self.secondarySet = 1000
        self.storage = [None] * self.primarySet
        
    #Modulo and division can be switched and it will work
    def _hash_primary(self, key):
        return key % self.primarySet

    def _hash_secondary(self, key):
        return key // self.secondarySet

    def add(self, key):
        primary_index = self._hash_primary(key)
        secondary_index = self._hash_secondary(key)
        #If primary index is none, initialize the secondary array
        if not self.storage[primary_index]:
            self.storage[primary_index] = [False] * (self.secondarySet + 1)
        self.storage[primary_index][secondary_index] = True

    def remove(self, key):
        primary_index = self._hash_primary(key)
        secondary_index = self._hash_secondary(key)
        if self.storage[primary_index] is None:
            return
        self.storage[primary_index][secondary_index] = False

    def contains(self, key):
        primary_index = self._hash_primary(key)
        secondary_index = self._hash_secondary(key)
        if self.storage[primary_index] is None:
            return False
        return self.storage[primary_index][secondary_index]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)