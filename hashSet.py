class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.storage= [None] * self.buckets
    
    def getBucket(self, key: int)-> int:
        return key % self.buckets
    
    def getBucketItems(self, key: int)-> int:
        return key // self.bucketItems
        

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        buckeItem = self.getBucketItems(key)
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.buckets+1)
            else:
                self.storage[bucket] = [None] * self.buckets
        
        self.storage[bucket][buckeItem] = True  
            

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        buckeItem = self.getBucketItems(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][buckeItem] = False
        

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        buckeItem = self.getBucketItems(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][buckeItem]
        
