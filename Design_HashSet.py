//Time Complexity: O(1)
//Space Complexity: O(N)
Issue Faced: 
class MyHashSet:
    
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def hash1(self, key: int) -> int:
        return key % self.buckets

    def hash2(self, key: int) -> int:
        return key // self.buckets

    def add(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if self.storage[hash1] is None:
            self.storage[hash1] = [False] * (self.buckets + 1) if hash1 == 0 else [False] * self.buckets
        self.storage[hash1][hash2] = True

    def remove(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if self.storage[hash1] is not None:
            self.storage[hash1][hash2] = False

    def contains(self, key: int) -> bool:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        return self.storage[hash1] is not None and self.storage[hash1][hash2]

# Usage
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
