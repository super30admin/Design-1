
# Time Complexity : Add: O(1) Remove: O(1) Contain:O(1)
# Space Complexity : O(n)
# Code ran successfully run on Leetcode 
# I am using double hashing : 1st hash func which stores element in the index key % 100 of the list. And second stores in key /100                                                                          

class MyHashSet:

    def __init__(self):
        self.MAX = 1000
        #self.lst = [[][] for i in range(self.MAX)]
        self.lst = [None] * self.MAX 
        
    def get_hash(self, key: int) -> int:
        hash_code = int(key % self.MAX)
        return hash_code
    
    def get_buckItem(self, key: int) -> int:
        return int(key / self.MAX)
    
    def add(self, key: int) -> None:
        
        # If key already exists, don't add
        if self.contains(key):
            return
        bucket = self.get_hash(key)
        buck_item = self.get_buckItem(key)
        if self.lst[bucket] is None:
            if (bucket == 0):
                self.lst[bucket]  = [False] * 1001
            else:
                self.lst[bucket]  = [False] * 1000
            # allocate 
        
        
        # Add key only if it doesn't exist
       # self.get_Hash(key)
        #if len(self.lst[hcode]) <= 0:
            
        self.lst[bucket][buck_item] =  True
        
    def remove(self, key: int) -> None:
        
        # If the key doesn't exist, it can't be removed
        if self.contains(key) is False:
            return
        bucket = self.get_hash(key)
        buck_item = self.get_buckItem(key)
        
        # Remove the key , by changing its status to False 
        self.lst[bucket][buck_item] =  False
    
    def contains(self, key: int) -> bool:
        
        """
        Returns true if this set contains the specified element
        """
        bucket = self.get_hash(key)
        buck_item = self.get_buckItem(key)
       
        # If bucket is None, then it implies item doesn't exist
        if  self.lst[bucket] is None :
            return False
        
        # Else return the status of bucket item
        else:
            return self.lst[bucket][buck_item]
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
