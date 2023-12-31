class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.hashSetStorage = [[]] * self.buckets

    def primary(self, key):
        return key % self.buckets

    def secondary(self, key):
        return key // self.buckets

    def add(self, key: int) -> None:
        hash1 = self.primary(key)
        hash2 = self.secondary(key)
        if self.hashSetStorage[hash1] == []:
            if hash1 == 0:
                self.hashSetStorage[hash1] = [False] * (self.bucketItems+1)
            else:
                self.hashSetStorage[hash1] = [False] * self.bucketItems
        self.hashSetStorage[hash1][hash2] = True    

    def remove(self, key: int) -> None:
        hash1 = self.primary(key)
        hash2 = self.secondary(key)
        if self.hashSetStorage[hash1] == []:
            return -1
        self.hashSetStorage[hash1][hash2] = False
        
    def contains(self, key: int) -> bool:
        hash1 = self.primary(key)
        hash2 = self.secondary(key)
        if self.hashSetStorage[hash1]:
            return self.hashSetStorage[hash1][hash2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)