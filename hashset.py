#time complexity: O(1) for  add, remove and contain
#space complexity: O(n) 
#passed all cases on LeetCode: yes
#difficulty faced: still making mistakes - not adding self for class variables and 
# comments: in this solution initial bucket is a primary array which is of size sqroot of max so 10^3 for max size of (key) 10^6
#so each element of primary array should have it's own 10^3 elements to map all the keys and so that they do not collide, this size is indicated by bucketItem
#allocate new array at location hash1 when we map to new hash1 location

class MyHashSet:

    def __init__(self):
        
        
        self.bucket = 1000
        self.bucketItem = 1000
        self.storage = [None]*self.bucket
    
    def hashing1(self, key):
        return key%self.bucket
    
    def hashing2(self,key):
        return key//self.bucketItem
        
    def add(self, key: int) -> None:
        h1 = self.hashing1(key)
        h2 = self.hashing2(key)
        #if the array at this index doesnt exist we need to create it
        #there is an edgecase when input is 10**6 so for that we need to allocate an extra bucketitem for array element 0
        if not self.storage[h1] and h1==0:
            self.storage[h1] = [False]*(self.bucketItem+1)
        elif not self.storage[h1]:
             self.storage[h1] = [False]*(self.bucketItem)
        
        self.storage[h1][h2] = True

    def remove(self, key: int) -> None:
        h1 = self.hashing1(key)
        h2 = self.hashing2(key)
        if self.storage[h1]:
            #h2 = self.hashing2(key)
            self.storage[h1][h2] = False
            

    def contains(self, key: int) -> bool:
        h1 = self.hashing1(key)
        h2 = self.hashing2(key)
        if self.storage[h1]:
            #h2 = self.hashing2(key)
            return self.storage[h1][h2]
        
