// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyHashSet:

    def __init__(self):
        self.lst = 1000
        self.sublst = 1000
        self.storage = [[] for _ in range(self.lst)]

    def hashfun1(self,key):
        return key%self.lst

    def hashfun2(self,key):
        return key//self.sublst

    def add(self, key: int) -> None:
        hashval1 = self.hashfun1(key)
        hashval2 = self.hashfun2(key)
        if not self.storage[hashval1]:
            self.storage[hashval1] = [False] * (self.sublst + 1)
        else:
            if len(self.storage[hashval1]) <= hashval2:
                self.storage[hashval1] += [False] * (hashval2 - len(self. storage[hashval1]) + 1)
        self.storage[hashval1][hashval2] = True

    def remove(self, key: int) -> None:
        hashval1 = self.hashfun1(key)
        hashval2 = self.hashfun2(key)
        if not self.storage[hashval1] or len(self.storage[hashval1]) <= hashval2:
            return
        self.storage[hashval1][hashval2] = False

    def contains(self, key: int) -> bool:
        hashval1 = self.hashfun1(key)
        hashval2 = self.hashfun2(key)
        if not self.storage[hashval1] or len(self.storage[hashval1]) <= hashval2:
            return False
        return self.storage[hashval1][hashval2]
