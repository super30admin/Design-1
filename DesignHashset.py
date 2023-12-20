#Time complexity for inner and outer hash = O(1)
#Space complexity: O(1) 
#Approach: 1)used double hashing technique to solve the problem
#2) Initialized the data structure by defining the number of buckets, the bucket size, and initializing the storage array with None.
#3)  implemented two hashing functions, getOuterHash and getInnerHash
class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketSize = 1000
        self.storage = [None] * self.buckets 

    def getOuterHash(self, key):
        return key % self.buckets

    def getInnerHash(self, key):
        return key // self.bucketSize

    def add(self, key: int) -> None:
        outerHash = self.getOuterHash(key)
        if self.storage[outerHash] is None:
            if outerHash == 0:
                self.storage[outerHash] = [False] * (self.bucketSize + 1)
            else:
                self.storage[outerHash] = [False] * self.bucketSize
        innerHash = self.getInnerHash(key)
        self.storage[outerHash][innerHash] = True

        
        

    def remove(self, key: int) -> None:
        outerHash = self.getOuterHash(key)
        if self.storage[outerHash] is not None:
            innerHash = self.getInnerHash(key)
            self.storage[outerHash][innerHash] = False
        

    def contains(self, key: int) -> bool:
        outerHash = self.getOuterHash(key)
        if self.storage[outerHash] is None:
            return False
        else:
            innerHash = self.getInnerHash(key)
            return self.storage[outerHash][innerHash]
        
#Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)