class MyHashSet:

    def __init__(self):
        self.k = (10 ** 3)
        self.hashSet = [None] * self.k

    def add(self, key: int) -> None:
        key1 = key % self.k
        key2 = key // self.k
        
        if self.hashSet[key1] == None:
            self.hashSet[key1] = [None] * (self.k + 1)
        
        self.hashSet[key1][key2] = key
        

    def remove(self, key: int) -> None:
        key1 = key % self.k
        key2 = key // self.k
        if self.hashSet[key1] != None:
            if self.hashSet[key1][key2] == key:
                self.hashSet[key1][key2] = -1
                
    def contains(self, key: int) -> bool:
        key1 = key % self.k
        key2 = key // self.k
        if self.hashSet[key1] != None:
            return self.hashSet[key1][key2] == key

            
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)