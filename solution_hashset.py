class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.buckets = [None]*self.size
        

    def add(self, key: int) -> None:
        hash_key = key%self.size
        pos = key//self.size
        
        if self.buckets[hash_key] is None:
            if hash_key == 0:
                self.buckets[hash_key] = [False]*(self.size + 1)
            else:
                self.buckets[hash_key] = [False]*self.size
                
        self.buckets[hash_key][pos] = True
                
    def remove(self, key: int) -> None:
        hash_key = key%self.size
        pos = key//self.size
        
        if self.buckets[hash_key] is not None:
            self.buckets[hash_key][pos] = False
        

    def contains(self, key: int) -> bool:
        hash_key = key%self.size
        pos = key//self.size
        
        if self.buckets[hash_key] is not None:
            
            if self.buckets[hash_key][pos] == True:
                return True
            else:
                return False
            
        else:
            return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
