class MyHashSet:

    def __init__(self):
        self.rows, self.cols = 1000, 1000
        self.array = [None] * self.rows

    def hash1(self, key):
        return key % self.rows

    def hash2(self, key):
        return key // self.rows

    def add(self, key: int) -> None:
        idx = self.hash1(key)
        if not self.array[idx]:
            if idx == 0:
                self.array[0] = [False]*(self.cols+1)
            else:
                self.array[idx] = [False]*(self.cols)
        idx1 = self.hash2(key)
        self.array[idx][idx1] = True

    def remove(self, key: int) -> None:
        idx = self.hash1(key)
        idx1 = self.hash2(key)
        if not self.array[idx]:
            return
        self.array[idx][idx1] = False

    def contains(self, key: int) -> bool:
        idx = self.hash1(key)
        idx1 = self.hash2(key)
        if not self.array[idx]:
            return False
        return self.array[idx][idx1]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
