class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.table = [None] * self.size
    
    def hash1(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        hv = self.hash1(key)
        
        if self.table[hv] == None:
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)

    def remove(self, key: int) -> None:
        hv = self.hash1(key)
        
        if self.table[hv] != None:
            while key in self.table[hv]: 
                self.table[hv].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hv = self.hash1(key)
        
        if self.table[hv] != None:
            return key in self.table[hv]
        return False
