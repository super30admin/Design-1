class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets
    
    def hash1(self, key: int):
        return key % 1000

    def hash2(self, key: int):
        return key // 1000
        
    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.bucketItems += 1
            self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)