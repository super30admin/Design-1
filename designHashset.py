#TimeComplexity: add remove Search all in O(1)
#SpaceComplexity: O(N)
#It successfully runs on leetcode
#I faced difficulty while initializing and using 2d array

class MyHashSet:
    buckets, bucketitems=0,0
    storage=[[]]
    
    def __init__(self):
        self.buckets=1000
        self.bucketitems=1000
        self.storage=[None] * (self.buckets)
        
    def bucket(self,key):
        return key%1000
    
    def bucketitem(self,key):
        return key//1000
        

    def add(self, key: int) -> None:
        bucket= self.bucket(key)
        bucketitem=self.bucketitem(key)
        #To handle last 1000000 the element
        if self.storage[bucket]==None:
            if bucket==0:
                self.storage[bucket]=[False]* (self.bucketitems+1)
            else:
                self.storage[bucket]=[False]* (self.bucketitems)
        
        self.storage[bucket][bucketitem]=True
            
        
    def remove(self, key: int) -> None:
        bucket=self.bucket(key)
        bucketitem=self.bucketitem(key)
        if self.storage[bucket]==None: 
            return 
        self.storage[bucket][bucketitem]=False
      
            
    def contains(self, key: int) -> bool:
        bucket=self.bucket(key)
        bucketitem=self.bucketitem(key)
        if self.storage[bucket]==None:
            return False
        return self.storage[bucket][bucketitem]
        


