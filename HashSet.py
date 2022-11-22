class MyHashSet:

    def __init__(self):
        self.storage = [False]*1000
        
    def hash1(self,key):
        return key%1000
    
    def hash2(self,key):
        return key // 1000
    
            

    def add(self, key: int) -> None:
        key1 = self.hash1(key)
        key2 = self.hash2(key)
        if not self.storage[key1]:
            if key1 == 0:
                self.storage[key1] = [False]*1001
            else:
                self.storage[key1] = [False]* 1000
        self.storage[key1][key2] = True        
        

    def remove(self, key: int) -> None:
        key1 = self.hash1(key)
        key2 = self.hash2(key)
        if not self.storage[key1]:
            return
        self.storage[key1][key2] = False
        return
        
        

    def contains(self, key: int) -> bool:
        key1 = self.hash1(key)
        key2 = self.hash2(key)
        if not self.storage[key1]:
            return False
        if self.storage[key1][key2] == True:
            return True
        return False
    
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)