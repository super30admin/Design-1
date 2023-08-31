class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.bucket = [None] * self.size

    def hash_func(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        hf = self.hash_func(key)

        if self.bucket[hf] == None:
            self.bucket[hf] = [key]
        else:
            self.bucket[hf].append(key)

    def remove(self, key: int) -> None:
        hf = self.hash_func(key)

        if self.bucket[hf] != None:
            while key in self.bucket[hf]:
                self.bucket[hf].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified key
        """
        hf = self.hash_func(key)

        if self.bucket[hf] != None:
            return key in self.bucket[hf]
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)