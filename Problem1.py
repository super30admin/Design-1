class MyHashSet:

    def __init__(self):
        self.prim_buckets = 1000
        self.sec_buckets = 1000
        self.storage = [None] * 1000

    def hash1(self, key):
        return key % self.prim_buckets

    def hash2(self, key):
        return key // self.sec_buckets

    def add(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.storage[h1] is None:
            if h1 == 0:
                self.storage[h1] = [None] * 1001
            else:
                self.storage[h1] = [None]*1000
        self.storage[h1][h2] = True

    def remove(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.storage[h1] is None:
            pass
        else:
            self.storage[h1][h2] = False
        

    def contains(self, key: int) -> bool:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.storage[h1] is None:
            return False
        else:
            return self.storage[h1][h2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)