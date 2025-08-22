class MyHashSet:

    def __init__(self):
        self.Bucket=1000
        self.BucketItems=1000
        self.Storage=[None]*self.Bucket

    
    def hash1(self, key: int) -> None:
        return key % self.Bucket
    
    
    def hash2(self, key: int) -> None:
        return key // self.BucketItems

    def add(self, key: int) -> None: # O(1)
        primary_index=self.hash1(key)
        if self.Storage[primary_index] is None:
            if primary_index==0:
                self.Storage[primary_index]=[False]*(self.BucketItems+1)
            else:
                self.Storage[primary_index]=[False]*self.BucketItems
        secondary_index=self.hash2(key)
        self.Storage[primary_index][secondary_index]=True

    def remove(self, key: int) -> None:  # O(1)
        primary_index=self.hash1(key)
        if self.Storage[primary_index] is None:
            return
        secondary_index=self.hash2(key)
        self.Storage[primary_index][secondary_index]= False
        

    def contains(self, key: int) -> bool:  # O(1)
        primary_index=self.hash1(key)
        if self.Storage[primary_index] is None:
            return False
        secondary_index=self.hash2(key)
        return self.Storage[primary_index][secondary_index]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)