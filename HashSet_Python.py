class MyHashSet:

    def __init__(self):
        
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None for i in range(0,self.buckets)]
        
    def add(self, key: int) -> None:
        bucket = key % 1000
        bucketItem = key // 1000


        if self.storage[bucket] == None:
            if (bucket == 0):
                self.storage[bucket] = [ False for i in range(0, self.bucketItems + 1)]
            else:
                self.storage[bucket] = [False for i in range(0,self.bucketItems)]
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        bucket = key % 1000
        bucketItem = key // 1000

        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False   
        

    def contains(self, key: int) -> bool:
        bucket = key % 1000
        bucketItem = key // 1000

        if self.storage[bucket] == None:
            return False

        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)