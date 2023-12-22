

#hash1 is a simple hash function that will generate the index of key
#add function will add key at index and contain function will check if key is exist or not
#remove function will remove the key if key is exist 

class MyHashSet:
    
    def __init__(self):
        self.capasity = 1000
        self.bucket = [None]*self.capasity
    def hash1(self,key) -> int:
        return key%self.capasity
        
    def add(self, key: int) -> None:
        idx = self.hash1(key)
        if not self.bucket[idx]:
            self.bucket[idx]=[]
        if key not in self.bucket[idx]:
            self.bucket[idx].append(key) 
        
    def remove(self, key: int) -> None:
        idx = self.hash1(key)
        if self.bucket[idx] and key in self.bucket[idx]:
            self.bucket[idx].remove(key)

    def contains(self, key: int) -> bool:
        idx = self.hash1(key)
        return self.bucket[idx] and key in self.bucket[idx]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)