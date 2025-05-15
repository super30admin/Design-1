"""
I implemented a hash set using the technique taught in the session.
"""
class MyHashSet:

    def __init__(self):
        self.hashSet = [None] * 1000
        self.buckets = 1000
        self.bucketItems = 1000
    
    def hash_function1(self, value):
        return value % self.buckets
    
    def hash_function2(self, value):
        return value // self.bucketItems
        
    def add(self, key: int) -> None:
        i = self.hash_function1(key)
        j = self.hash_function2(key)
        if self.hashSet[i] is None:
            if i == 0:
                self.hashSet[i] = [False] * (self.bucketItems + 1)
            else:
                self.hashSet[i] = [False] * self.bucketItems
        self.hashSet[i][j] = True

    def remove(self, key: int) -> None:
        i = self.hash_function1(key)
        j = self.hash_function2(key)
        if self.hashSet[i] is None:
            return
        self.hashSet[i][j] = False
    
    def contains(self, key: int) -> bool:
        i = self.hash_function1(key)
        j = self.hash_function2(key)
        return self.hashSet[i] is not None and self.hashSet[i][j]
        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)