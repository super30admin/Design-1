# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

class MyHashSet:

    def __init__(self):
        self.primary_size = 1000 
        self.secondary_size = 1000
        self.storage = [None]*1000

    def getPrimaryHash(self,val):
        return val%self.primary_size

    def getSecondaryHash(self,val):
        return val // self.secondary_size

    def add(self, key: int) -> None:
        # add only if it doesnt exist
        primary_hash = self.getPrimaryHash(key)
        secondary_hash = self.getSecondaryHash(key)
        if self.storage[primary_hash] == None:
            if primary_hash == 0:
                self.storage[primary_hash] = [False]* (self.secondary_size+1)
            else:
                self.storage[primary_hash] = [False]*self.secondary_size
        self.storage[primary_hash][secondary_hash] = True 

    def remove(self, key: int) -> None:
        primary_hash = self.getPrimaryHash(key)
        secondary_hash = self.getSecondaryHash(key)
        if self.storage[primary_hash] == None:
            return None
        else:
            self.storage[primary_hash][secondary_hash] = False 

    def contains(self, key: int) -> bool:
        primary_hash = self.getPrimaryHash(key)
        secondary_hash = self.getSecondaryHash(key)
        if self.storage[primary_hash] == None:
            return False
        return self.storage[primary_hash][secondary_hash] 


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)