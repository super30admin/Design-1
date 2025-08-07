class MyHashSet:
    def __init__(self):
        self.PrimaryBuckets = 1000
        self.SecondaryBuckets = 1000
        self.storage = [None] * self.PrimaryBuckets

    def getPrimarykey(self, key):
        return key%self.PrimaryBuckets
    
    def getSecondarykey(self,key):
        return key//self.SecondaryBuckets

    def add(self, key: int) -> None:
        primaryIndex = self.getPrimarykey(key)
        secondaryIndex = self.getSecondarykey(key)
        if self.storage[primaryIndex] is None:
            if primaryIndex == 0:
                self.storage[primaryIndex] = [False] * (self.SecondaryBuckets + 1)
            else:
                self.storage[primaryIndex] = [False] * self.SecondaryBuckets
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key: int) -> None:
        primaryIndex = self.getPrimarykey(key)
        secondaryIndex = self.getSecondarykey(key)
        if self.storage[primaryIndex] is None:
            return
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key: int) -> bool:
        primaryIndex = self.getPrimarykey(key)
        secondaryIndex = self.getSecondarykey(key)
        if self.storage[primaryIndex] is None:
            return False
        return self.storage[primaryIndex][secondaryIndex]