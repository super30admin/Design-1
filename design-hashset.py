# Time Complexity : O(1)
# Space complexity : O(n)


# Code tested and submitted on leet code

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = [None] * self.buckets
    
    def getBucket(self,key):
        return key % self.buckets 
    
    def getBucketItems(self,key): 
        return key // self.buckets
        

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        if not self.bucketItems[bucket] and bucket==0: 
            self.bucketItems[bucket] = [False] * self.buckets+1

        elif not self.bucketItems[bucket]: 
            self.bucketItems[bucket] = [False] * self.buckets

        self.bucketItems[bucket][bucketItem] = True 
        

    def remove(self, key: int) -> None:
        bucket= self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        if self.bucketItems[bucket]: 
            self.bucketItems[bucket][bucketItem] = False        
        

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        if self.bucketItems[bucket]:
            return self.bucketItems[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
