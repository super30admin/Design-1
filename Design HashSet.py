# Time Complexity: O(1) for add, remove, and contains
# Space Complexity: O(1), because the maximum key range is fixed
# Did this code successfully run on LeetCode: Yes

class MyHashSet(object):

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.storage = [None] * self.primaryBuckets

    def getPrimaryHash(self, key):
        return key % self.primaryBuckets

    def getSecondaryHash(self, key):
        return key // self.secondaryBuckets   
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryHash = self.getPrimaryHash(key)
        if self.storage[primaryHash] == None:
            if primaryHash == 0:
                self.storage[primaryHash] = [False] * (self.secondaryBuckets + 1)
            else:
                self.storage[primaryHash] = [False] * self.secondaryBuckets
        secondaryHash = self.getSecondaryHash(key)
        self.storage[primaryHash][secondaryHash] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryHash = self.getPrimaryHash(key)
        if self.storage[primaryHash] is None:
            return
        secondaryHash = self.getSecondaryHash(key)
        self.storage[primaryHash][secondaryHash] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primaryHash = self.getPrimaryHash(key)
        if self.storage[primaryHash] is None:
            return False
        secondaryHash = self.getSecondaryHash(key)
        return self.storage[primaryHash][secondaryHash]


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.remove(1)
print(obj.contains(1))