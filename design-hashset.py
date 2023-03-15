class MyHashSet:

    def __init__(self):
        self.buckets=1000 #indices of primary array, value is 1000, as constraint is 10 ^6. So half in pri arr and half in sec arr
        self.bucketItems=1000 #indices of secondary array
        self.storage=[None]*self.buckets #fill in primary array with None
    
    #get index in primary arr
    def getBucket(self,key): #key is int
        return key%self.buckets
    
    #get index of secondary array
    def getBucketItem(self,key):
        return key//self.bucketItems


    def add(self, key: int) -> None:
        bucket=self.getBucket(key) #get index of primary arr
        bucketItem=self.getBucketItem(key) #get index of secondary array
        if self.storage[bucket]==None:
            if bucket==0: #if first index of pri arr
                self.storage[bucket]=[False]*(self.bucketItems +1) #taking care of index zero in priamry arr, because we can get index of 1000 for 10^6 key and for us it will be out of bound, beacuse last index we have is 999
            else:
                self.storage[bucket]=[False]*self.bucketItems #Fill in secondary array with False, when value comes, change to true
        self.storage[bucket][bucketItem]=True
        


    def remove(self, key: int) -> None:
        bucket=self.getBucket(key)
        bucketItem=self.getBucketItem(key)
        if self.storage[bucket]==None:  #secondary arr doesn't exist at pri arr index
            return
        self.storage[bucket][bucketItem]=False
  
        
    def contains(self, key: int) -> bool:
        bucket=self.getBucket(key)
        bucketItem=self.getBucketItem(key)
        if self.storage[bucket]==None:
            return False  
        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)