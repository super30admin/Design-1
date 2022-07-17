# Time compelxity: O(1)

class MyHashSet:

    def __init__(self):
        self.buckets  = 1000
        self.bucketItems  = 1000
        self.storage  = [None]*1000 

    def bucket(self, key: int):
        return key % self.buckets
    
    def bucketItem(self, key: int):
        return key // self.bucketItems
    
    
    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [None]*(self.bucketItems +1)
            else:
                self.storage[bucket] = [None]*(self.bucketItems)
                
        self.storage[bucket][bucketItem] = True
        
        
    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.storage[bucket] is None:
                return
        self.storage[bucket][bucketItem] = False
            
    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        if self.storage[bucket] is None:
            return False
        return  self.storage[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.add(3)
obj.remove(2)
param_3 = obj.contains(3)
print(param_3)