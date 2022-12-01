class MyHashSet:

    def __init__(self):
        self.bucketsize = 10000
        self.buckets = [[] for i in range(self.bucketsize)]

    def hashFunc(self, key):
        return key % self.bucketsize

    def add(self, key: int) -> None:
        i = self.hashFunc(key)
        if key not in self.buckets[i]:
            self.buckets[i].append(key)


    def remove(self, key: int) -> None:
        i = self.hashFunc(key)
        if key in self.buckets[i]:
            self.buckets[i].remove(key)

    def contains(self, key: int) -> bool:
        i = self.hashFunc(key)
        if key in self.buckets[i]:
            return True
        else:
            return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)