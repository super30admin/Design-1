class MyHashSet:
    def __init__(self):
        self.MAX = 10 ** 3
        self.arr = [None for i in range(self.MAX)]

    def get_hash1(self, key):
        return key % self.MAX

    def get_hash2(self, key):
        return key // self.MAX

    def add(self, key):
        h1 = self.get_hash1(key)
        h2 = self.get_hash2(key)
        if not self.arr[h1] and h1 == 0:
            self.arr[h1] = [False] * (self.MAX + 1)
        elif not self.arr[h1]:
            self.arr[h1] = [False] * (self.MAX)
        self.arr[h1][h2] = True

    def remove(self, key):
        h1 = self.get_hash1(key)
        h2 = self.get_hash2(key)
        if self.arr[h1]:
            self.arr[h1][h2] = False

    def contains(self, key):
        h1 = self.get_hash1(key)
        h2 = self.get_hash2(key)
        if self.arr[h1]:
            return self.arr[h1][h2]

