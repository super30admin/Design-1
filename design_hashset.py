## // Time Complexity :average time complexity O(1) and in worst case O(C) length of chain 
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


class designHashSet:
    def __init__(self):
        self.totalbucket=1500 #random bucket size based on keys and number of call that can be made
        self.arr=[[] for i in range(self.totalbucket)] #array of empty buckets i.e. list(list)

        #the collision resolution technique used here is separate chaining
    def helperHashfunction(self,key):
        #taking modulo of total bucket size
        return key%self.totalbucket    
        
    
    def add(self, key: int) -> None:

        temp=self.helperHashfunction(key)
           #check if key is at temp index or not
        if key not in self.arr[temp]:
            self.arr[temp].append(key)
        
        

    def remove(self, key: int) -> None:
        temp=self.helperHashfunction(key)
        #check if key is at temp index
        if key in self.arr[temp]:
            self.arr[temp].remove(key)
        

    def contains(self, key: int) -> bool:
        temp=self.helperHashfunction(key)
        if key in self.arr[temp]:
            return True

    def contains(self, key: int) -> bool:
        temp=self.helperHashfunction(key)
        if key in self.arr[temp]:
            return True
        return False
    
    def show(self):
        return self.arr



hashset=designHashSet()

hashset.add(1)
hashset.add(2)
print(hashset.contains(1))    # returns true
print(hashset.contains(3))   #returns false (not found)
hashset.add(2)
print(hashset.show())         
hashset.contains(2)   # returns true
print(hashset.remove(2)) 
print(hashset.show())         






