class MyHashSet:

    def __init__(self):
        self.hashSet=[]
        primary = 10000
        secondary = 10000
    def key1(self,index):
        return index%primary
    def key2(self,index):
        return index//secondary

    def add(self, key: int) -> None:
        if not key in self.hashSet:
            self.hashSet.append(key)

    def remove(self, key: int) -> None:
        if key in self.hashSet:
            self.hashSet.remove(key)


    def contains(self, key: int) -> bool:
        if key in self.hashSet:
            return True
        return False



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)