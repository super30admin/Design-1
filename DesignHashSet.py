# TC -O(1) SC - O(n)
class MyHashSet:

    def __init__(self):
        self.hashset = [None] * 1000
        self.length = len(self.hashset)

    def hash1(self, key):
        return key % self.length

    def hash2(self, key):
        return key // self.length

    def add(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.hashset[hash1] == None:

            self.hashset[hash1] = [False] * 1000
            if hash1 == 0:
                self.hashset[hash1] = [False] * 1001

        self.hashset[hash1][hash2] = True

    def remove(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if self.hashset[hash1] == None:
            return
        else:

            self.hashset[hash1][hash2] = False

    def contains(self, key: int) -> bool:

        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if self.hashset[hash1] == None:
            return False
        else:
            return self.hashset[hash1][hash2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
