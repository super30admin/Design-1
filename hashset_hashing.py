# 1. Implement the custum MyHashSet using "Double Hashing Technique"
# 2. We define two hash functions mainly one for the primary array which is the array of booleon array
# Time Complexity:
# add(), remove(), contains() -> O(1)
# Space Complexity: O(1)

class MyHashSet:

    def __init__(self):
        self.primary_size = 1000
        self.secondary_size = 1001
        self.buckets = [None] * self.primary_size
    
    def primaryHash(self, key: int) -> int:
        return key % self.primary_size
    
    def secondaryHash(self, key: int) -> int:
        return key // self.secondary_size

    def add(self, key: int) -> None:
        primary_index = self.primaryHash(key)
        if self.buckets[primary_index] is None:
            self.buckets[primary_index] = [False] * self.secondary_size

        secondary_index = self.secondaryHash(key)
        self.buckets[primary_index][secondary_index] = True

    def remove(self, key: int) -> None:
        primary_index = self.primaryHash(key)
        if self.buckets[primary_index] is None:
            return
        
        secondary_index = self.secondaryHash(key)
        self.buckets[primary_index][secondary_index] = False

    def contains(self, key: int) -> bool:
        primary_index = self.primaryHash(key)
        if self.buckets[primary_index] is None:
            return False
        
        secondary_index = self.secondaryHash(key)
        return self.buckets[primary_index][secondary_index]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
