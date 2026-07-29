# Implemented using double hashing
# TC -> O(1)
# SC -> O(10^6) or O(N)

class MyHashSet:
    def __init__(self):
        self.num_buckets = 1000
        self.buckets = [None] * self.num_buckets

    def add(self, key: int) -> None:
        first_hash = self.first_hash(key)
        second_hash = self.second_hash(key)
        if self.buckets[first_hash] == None:
            if first_hash == 0:
                self.buckets[first_hash] = [False] * (self.num_buckets + 1)
            else:
                self.buckets[first_hash] = [False] * self.num_buckets
        self.buckets[first_hash][second_hash] = True
        return
    def remove(self, key: int) -> None:
        first_hash = self.first_hash(key)
        second_hash = self.second_hash(key)
        if self.buckets[first_hash]:
            self.buckets[first_hash][second_hash] = False
        return
    def contains(self, key: int) -> bool:
        first_hash = self.first_hash(key)
        second_hash = self.second_hash(key)
        if self.buckets[first_hash]:
            return self.buckets[first_hash][second_hash]
        return False
    def first_hash(self, key) -> int:
        return key % self.num_buckets
    def second_hash(self, key) -> int:
        return key // self.num_buckets

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)