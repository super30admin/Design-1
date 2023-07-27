# Designing Hashset

# Time Complexity :o(1)
 #Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes



#There are two key questions that one should address, in order to implement the HashSet data structure, namely hash function and collision handling.

#hash function: the goal of the hash function is to assign an address to store a given value. Ideally, each unique value should have a unique hash value.

#collision handling: since the nature of a hash function is to map a value from a space A into a corresponding value in a smaller space B, it could happen that multiple values from space A might be mapped to the same value in space B. This is what we call collision. Therefore, it is indispensable for us to have a strategy to handle the collision.

class MyHashSet:

    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.storage=[None]*self.buckets
    
    def getbucket(self,key:int)-> int:
        return key%self.buckets
    
    def getbucketItems(self,key:int)-> int:
        return key//self.bucketItems
    
    def add(self, key: int) -> None:
        bucket=self.getbucket(key)
        bucketItem=self.getbucketItems(key)

        if self.storage[bucket]==None:
            if bucket==0:
                self.storage[bucket]=[None]*(self.bucketItems+1)
            else:
                self.storage[bucket]=[None]*self.bucketItems            
        self.storage[bucket][bucketItem]= True
        

    def remove(self, key: int) -> None:
        bucket=self.getbucket(key)
        bucketItem=self.getbucketItems(key)

        if self.storage[bucket]==None:
            return
        self.storage[bucket][bucketItem]=None

    def contains(self, key: int) -> bool:
        bucket=self.getbucket(key)
        bucketItem=self.getbucketItems(key)

        if self.storage[bucket]==None:
            return False
        return self.storage[bucket][bucketItem]==True



# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)