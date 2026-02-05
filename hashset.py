# For adding a key, I first initialized by defining the size based on the value of key to accommodate for 0 to 10^6
#For Remove, if there is not value in table then false (default) if there is a value, then we assign that block to False

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.table = [None] * self.size

    def add(self, key: int) -> None:
        hash1 = key % self.size
        hash2 = key // self.size

        if self.table[hash1] is None: 
            if hash1 ==0:
                self.table[hash1] = [False] * (self.size + 1)
            else: 
                self.table[hash1] = [False] * self.size
        self.table[hash1][hash2] = True

    def remove(self, key: int) -> None:
        hash1 = key % self.size
        hash2 = key // self.size

        if self.table[hash1] is not None:
            self.table[hash1][hash2] = False


    def contains(self, key: int) -> bool:
        hash1 = key % self.size
        hash2 = key // self.size

        if self.table[hash1] is None:
            return False
        return self.table[hash1][hash2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)