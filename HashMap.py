# Time complexity: O(1) for all three operations
# Space Complexity: O(n)
class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.storage = [None for i in range(self.bucket)]

    def add(self, key: int) -> None:
        if self.storage[key % self.bucket] == None:
            if key % self.bucket == 0:
                self.storage[key % self.bucket] = [False for i in range(self.bucket + 1)]
            else:
                self.storage[key % self.bucket] = [False for i in range(self.bucket)]
        # print(len(self.storage[key%self.bucket]))
        self.storage[key % self.bucket][key // self.bucket] = True
        # print("Add",self.storage)

    def remove(self, key: int) -> None:
        if self.storage[key % self.bucket]:
            self.storage[key % self.bucket][key // self.bucket] = False
            # print(self.storage)

    def contains(self, key: int) -> bool:
        if self.storage[key % self.bucket]:
            # print("Contains", self.storage)
            return self.storage[key % self.bucket][key // self.bucket]
        return False
        # print(self.storage)


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)