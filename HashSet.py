# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The storage bucket at 0th index needs additional space for edge case.

class MyHashSet:

    def __init__(self):
        self.bucketCount = 1000
        self.bucketItemsCount = 1000
        self.storage = [None]*self.bucketCount

    def hashFunction1(self, key: int):
        return key%self.bucketCount

    def hashFunction2(self, key: int):
        return key//self.bucketItemsCount

    def add(self, key: int) -> None:
        primaryKey = self.hashFunction1(key)
        secondaryKey = self.hashFunction2(key)
        if self.storage[primaryKey] is None:
            if primaryKey == 0:
                self.storage[primaryKey] = [False]*(self.bucketItemsCount+1)
            else:
                self.storage[primaryKey] = [False]*self.bucketItemsCount
        self.storage[primaryKey][secondaryKey] = True

    def remove(self, key: int) -> None:
        primaryKey = self.hashFunction1(key)
        secondaryKey = self.hashFunction2(key)
        if self.storage[primaryKey] is None:
            return
        self.storage[primaryKey][secondaryKey] = False

    def contains(self, key: int) -> bool:
        primaryKey = self.hashFunction1(key)
        secondaryKey = self.hashFunction2(key)
        if self.storage[primaryKey] is None:
            return False
        return self.storage[primaryKey][secondaryKey]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)