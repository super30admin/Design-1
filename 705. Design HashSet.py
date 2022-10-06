# Time Complexity is
# Space Complexity is O(n) in the worst case. Depending on no of calls. 
class MyHashSet:

    def __init__(self):
        self.bucket_1 = 1000
        self.bucket_2 = 1000
        self.hash_set = [[] for i in range(self.bucket_1 + 1)]

    def hash1(self, key):
        return key // self.bucket_1

    def hash2(self, key):
        return key % self.bucket_2

    def add(self, key: int) -> None:
        # O(1) Time Complexity
        _hash1 = self.hash1(key)
        _hash2 = self.hash2(key)

        if not self.hash_set[_hash1]:
            self.hash_set[_hash1] = [[] for i in range(self.bucket_2)]

        self.hash_set[_hash1][_hash2] = True

    def remove(self, key: int) -> None:
        # O(1) Time Complexity
        _hash1 = self.hash1(key)
        _hash2 = self.hash2(key)

        if self.hash_set[_hash1]:
            self.hash_set[_hash1][_hash2] = False

    def contains(self, key: int) -> bool:
        # O(1) Time Complexity
        _hash1 = self.hash1(key)
        _hash2 = self.hash2(key)

        if self.hash_set[_hash1]:
            return self.hash_set[_hash1][_hash2]

        return False