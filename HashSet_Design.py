class MyHashSet:

    def __init__(self):
        self.storage=[None for _ in range(1000)]
        

    def add(self, key: int) -> None:
        bucket=key%1000
        bucket_items=key//1000
        
        if self.storage[bucket] is None:
            if bucket==0:
                    self.storage[bucket]=[False for _ in range(1001)]
            else:
                    self.storage[bucket]=[False for _ in range(1000)]

        self.storage[bucket][bucket_items]=True
        

    def remove(self, key: int) -> None:
        bucket=key%1000
        bucket_items=key//1000
        
        if self.storage[bucket] is not None and self.storage[bucket][bucket_items]!=False:
            self.storage[bucket][bucket_items]=False
        

    def contains(self, key: int) -> bool:
        bucket=key%1000
        bucket_items=key//1000

        if self.storage[bucket] is not None and self.storage[bucket][bucket_items]!=False:
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)