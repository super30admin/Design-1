# Using Double hasing technique to design a HashSet
# Time Complexity for the add, remove and contains is O(1)
# Space complexity is O(n)  - because at max we can store 100000 
class MyHashSet:

    def __init__(self):
        self.primary=[None]*1000
    
    def primary_hash(self,key):
        return key%1000
    
    def secondary_hash(self,key):
        return key//1000
        

    def add(self, key: int) -> None:
        pIndx=self.primary_hash(key)
        sIndx=self.secondary_hash(key)
        if self.primary[pIndx]==None:
            if pIndx==0:
                self.primary[pIndx]=[False]*1001
            else:
                self.primary[pIndx]=[False]*1000
            self.primary[pIndx][sIndx]=True
        else:
            sIndx=self.secondary_hash(key)
            self.primary[pIndx][sIndx]=True
            
                
        
        

    def remove(self, key: int) -> None:
        pIndx=self.primary_hash(key)
        sIndx=self.secondary_hash(key)
        if self.primary[pIndx]!=None: 
            self.primary[pIndx][sIndx]=False
            
            
        

    def contains(self, key: int) -> bool:
        pIndx=self.primary_hash(key)
        sIndx=self.secondary_hash(key)
        if self.primary[pIndx]==None:
            return False
        else:
            
            return self.primary[pIndx][sIndx]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)