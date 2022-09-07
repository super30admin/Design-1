# Time Complexity : O(1)


class MyHashSet:

    def __init__(self):
        self.buckets =1000 
        self.bucketitems = [None]*self.buckets
    
    def getbuckets(self,key):
        return key%self.buckets 
    
    def getbucketitems(self,key): 
        return key//self.buckets
        
    def add(self, key: int) -> None:
        bucket = self.getbuckets(key)
        bucketsitem = self.getbucketitems(key)
        if not self.bucketitems[bucket] and bucket==0: 
            self.bucketitems[bucket]= [False]*(self.buckets+1)
        elif not self.bucketitems[bucket]: 
            self.bucketitems[bucket]=[False]*(self.buckets)
        self.bucketitems[bucket][bucketsitem]= True 
        
    def remove(self, key: int) -> None:
        bucket= self.getbuckets(key)
        bucketsitem = self.getbucketitems(key)
        if self.bucketitems[bucket]: 
            self.bucketitems[bucket][bucketsitem]= False 
        
    def contains(self, key: int) -> bool:
        bucket = self.getbuckets(key)
        bucketsitem = self.getbucketitems(key)
        if self.bucketitems[bucket]:
            return self.bucketitems[bucket][bucketsitem]

        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)