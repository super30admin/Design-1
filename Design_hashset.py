class MyHashSet:

    def __init__(self):
        self.firstarraybucket=1000
        self.secondarraybucket=1000
        self.bucket=[None]*self.firstarraybucket

    def firsthash(self,key):
        return key%self.firstarraybucket
        
    def secondhash(self,key):
        return key//self.secondarraybucket

    def add(self, key: int) -> None:
        primaryidx=self.firsthash(key)
        secondaryidx=self.secondhash(key)
        if self.bucket[primaryidx] is None:
            if primaryidx==0:
                self.bucket[primaryidx]=[False]*(self.secondarraybucket +1)
            else:
                self.bucket[primaryidx]=[False]*(self.secondarraybucket)
        self.bucket[primaryidx][secondaryidx]=True

    def remove(self, key: int) -> None:
        primaryidx=self.firsthash(key)
        secondaryidx=self.secondhash(key)
        if self.bucket[primaryidx] is None:
            return
        self.bucket[primaryidx][secondaryidx]=False
        

    def contains(self, key: int) -> bool:
        primaryidx=self.firsthash(key)
        secondaryidx=self.secondhash(key)
        if self.bucket[primaryidx] is None:
            return False
        return self.bucket[primaryidx][secondaryidx]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)