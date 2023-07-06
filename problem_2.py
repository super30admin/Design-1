class MyHashSet:

    def __init__(self):
        self.hash = list()
        for i in range(10):
            self.hash.append([])

    def add(self, key: int) -> None:
        if key in self.hash[key%10]:
            pass
        else:
            self.hash[key%10].append(key)

    def remove(self, key: int) -> None:
        if key in self.hash[key%10]:
            self.hash[key%10].remove(key)

    def contains(self, key: int) -> bool:
        return key in self.hash[key%10]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)