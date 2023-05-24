class MyHashSet:

    def __init__(self):
        self.items = []

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.items.append(key)

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.items.remove(key)

    def contains(self, key: int) -> bool:
        return key in self.items

        


# Your MyHashSet object will be instantiated and called as such:
#obj = MyHashSet()
#obj.add("key")
#obj.remove("key")
#param_3 = obj.contains("key")