class Bucket:
    def __init__(self):
        self.bucket = []

    def put(self, key, value):
        found = 0
        for i, kv in enumerate(self.bucket):
            if kv[0] == key:
                self.bucket[i] = (key, value)
                found = 1
                break

        if found == 0:
            self.bucket.append((key, value))

    def get(self, key):
        for k, v in self.bucket:
            if k == key:
                return v
        return -1

    def delete(self, key):
        for i, kv in enumerate(self.bucket):
            if kv[0] == key:
                del self.bucket[i]


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_space = 61
        self.hash_table = [Bucket()] * 61 # this is for demonstration only, a biggest prime number is recommended to
        # avoid more collisions

    def hash_function(self, key): # any good hash function like AES, SHA, FNV can be used here...
        return key % self.key_space

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_ = self.hash_function(key)
        self.hash_table[hash_].put(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_ = self.hash_function(key)
        return self.hash_table[hash_].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_ = self.hash_function(key)

        if self.hash_table[hash_].get(key) != -1:
            self.hash_table[hash_].delete(key)
            return True
        else:
            return False

"""
Space Complexity: O(n) excluding the key space 
Time Complexity:
put: O(1) amortized, O(n) worst case
del: O(1) amortized, O(n) worst case
get: O(1) amortized, O(n) worst case
"""