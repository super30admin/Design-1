#Design HashSet
#soltuion uses dobule hashing for implementing hashset
#TC: O(1)
#SC: O(N)
class MyHashSet:

    def __init__(self):
        self.size =1000 #primary array
        self.bucket = [None]*self.size
    
    def hash1(self,key):#first hashing function
        return key%self.size 
    
    def hash2(self,key): #secound hashing function 
        return key//self.size
        

    def add(self, key: int) -> None:
        hi = self.hash1(key)#hashindex
        dhi = self.hash2(key)#double hash index
        if not self.bucket[hi] and hi==0: #if bucket doesnt exist at the current index and hi is0
            self.bucket[hi]= [False]*(self.size+1)
        elif not self.bucket[hi]: #if bucket doesnt exist then create
            self.bucket[hi]=[False]*(self.size)
        self.bucket[hi][dhi]= True #true flag 
        

    def remove(self, key: int) -> None:
        hi= self.hash1(key)
        dhi = self.hash2(key)
        if self.bucket[hi]: #if item exists at the current index
            self.bucket[hi][dhi]= False #False signifies empty
        
        

    def contains(self, key: int) -> bool:
        hi = self.hash1(key)
        dhi = self.hash2(key)
        if self.bucket[hi]: #if item exists at index return the value
            return self.bucket[hi][dhi]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)