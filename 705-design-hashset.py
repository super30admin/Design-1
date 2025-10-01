class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.bucketItems = [[] for i in range(self.size)]
    
    def _hash(self, key: int) -> int:
        return key % self.size 

    def add(self, key: int) -> None:
        bucket = self.bucketItems[self._hash(key)]
        if key not in bucket:
            bucket.append(key)

    def remove(self, key: int) -> None:
        bucket = self.bucketItems[self._hash(key)]
        if key in bucket:
            bucket.remove(key)

    def contains(self, key: int) -> bool:
        bucket = self.bucketItems[self._hash(key)]
        return key in bucket
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)