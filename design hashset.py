class MyHashSet:

    def __init__(self):
        self.bucket=1000
        self.bucketItem=1000
        self.storage=[None]*self.bucket
    def hash1(self,key:int)->int:
        return key%1000
    def hash2(self,key:int)->int:
        return key//1000
    def add(self, key: int) -> None:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket]==None:
            if bucket==0:
                self.storage[bucket]=[False]*(self.bucketItem+1)
            else:
                self.storage[bucket]=[False]*(self.bucketItem)
        self.storage[bucket][bucketItem]=True
    def remove(self, key: int) -> None:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket]==None:
            return
        self.storage[bucket][bucketItem]=False
    def contains(self, key: int) -> bool:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket]==None:
            return False
        return self.storage[bucket][bucketItem]