class MyHashSet:
    def __init__(self):
        self.hashmap = [False for _ in range(1001)]

    def getPrimaryIndex(self, key):
        return key%1000
    
    def getSecondaryIndex(self, key):
        return key//1001

    def add(self, key: int) -> None:
        primary_index = self.getPrimaryIndex(key)
        if not self.hashmap[primary_index]:
            self.hashmap[primary_index] = [False]*1000
        
        secondary_index = self.getSecondaryIndex(key)
        self.hashmap[primary_index][secondary_index] = True

    def remove(self, key: int) -> None:
        primary_index = self.getPrimaryIndex(key)
        if not self.hashmap[primary_index]:
            return
        secondary_index = self.getSecondaryIndex(key)
        self.hashmap[primary_index][secondary_index] = False

    def contains(self, key: int) -> bool:
        primary_index = self.getPrimaryIndex(key)
        if not self.hashmap[primary_index]:
            return False

        #otherwise
        secondary_index = self.getSecondaryIndex(key)
        return self.hashmap[primary_index][secondary_index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
