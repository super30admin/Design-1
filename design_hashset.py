"""
Explanation: Using the python list as base hash table to store elements.
To caluclate hash index, used the inbuilt has method of python.
Initialized a hash table with approx 10^4 capacity.
"""
class MyHashSet:

    def __init__(self):
        self.capacity = 10000
        self.hash_table = [None] * self.capacity

    def _hash_function(self, key:int) -> int:
        return hash(key) % self.capacity

    def add(self, key: int) -> None:
        hash_index = self._hash_function(key)

        if self.hash_table[hash_index] is None:
            self.hash_table[hash_index] = [key]
        if key not in self.hash_table[hash_index]:
            self.hash_table[hash_index].append(key)

    def remove(self, key: int) -> None:
        hash_index = self._hash_function(key)

        if self.hash_table[hash_index] is not None and key in self.hash_table[hash_index]:
            self.hash_table[hash_index].remove(key)
        

    def contains(self, key: int) -> bool:
        hash_index = self._hash_function(key)

        if self.hash_table[hash_index] is not None and key in self.hash_table[hash_index]:
            return True
        return False