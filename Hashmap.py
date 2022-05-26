class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketList = 1000
        self.hashmap = [-1] * (self.bucket)

    def bucketHash(self, key):
        return key % 1000

    def bucketItemHash(self, key):
        return key // 1000

    def add(self, key: int) -> None:
        hash1 = self.bucketHash(key)
        if self.hashmap[hash1] == -1:
            self.hashmap[hash1] = [0] * (self.bucketList + 1)
        hash2 = self.bucketItemHash(key)
        # print(hash1,"value1", self.hashmap[hash1])
        self.hashmap[hash1][hash2] = 1

    def remove(self, key: int) -> None:
        hash1 = self.bucketHash(key)
        if self.hashmap[hash1] == -1: return
        hash2 = self.bucketItemHash(key)
        self.hashmap[hash1][hash2] = 0

    def contains(self, key: int) -> bool:
        hash1 = self.bucketHash(key)
        if self.hashmap[hash1] == -1: return 0
        hash2 = self.bucketItemHash(key)
        return self.hashmap[hash1][hash2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)