class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucketSize = 1000
        self.slotSize = 1001
        
        self.store = [None]*self.bucketSize
        
    def add(self, key: int) -> None:
        
        hashKey = key% self.bucketSize
        slotKey = key // self.bucketSize
        
        if self.store[hashKey] is None:
            self.store[hashKey] = [None]*self.slotSize
        
        self.store[hashKey][slotKey] = True 
        
    def remove(self, key: int) -> None:
        
        hashKey = key % self.bucketSize
        slotKey = key // self.bucketSize
        
        
        if self.store[hashKey] is None:
            return 
        self.store[hashKey][slotKey] = False
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashKey = key % self.bucketSize
        slotKey = key // self.bucketSize
        
        if self.store[hashKey] is None:
            return None
        
        return self.store[hashKey][slotKey]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)