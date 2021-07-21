
# Time Complexity : Add: O(1) Remove: O(1) Contain:O(1)
# Space Complexity : O(n)
# Code ran successfully run on Leetcode 
# I am using double hashing : 1st hash func which stores element in the index key % 100 of the list. And second stores in key /100                                                                          

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.MAX = 1000
        #self.lst = [ None for i in range(self.MAX)]
        self.lst = [None] * self.MAX 
        
    def get_hash(self, key: int) -> int:
        hash_code = int(key % self.MAX)
        return hash_code
    
    def get_buckItem(self, key: int) -> int:
        return int(key / self.MAX)   

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        bucket = self.get_hash(key)
        buck_item = self.get_buckItem(key)
        if self.lst[bucket] is None:
            if (bucket == 0):
                self.lst[bucket]  = [-1] * 1001
            else:
                self.lst[bucket]  = [-1] * 1000
        self.lst[bucket][buck_item] =  value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the         key
        """
        bucket = self.get_hash(key)
        buck_item = self.get_buckItem(key)
        
        # If bucket is None, return -1
        if self.lst[bucket] is None:
            return -1
        return self.lst[bucket][buck_item]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucket = self.get_hash(key)
        buck_item = self.get_buckItem(key)
        if self.lst[bucket] is None:
            return -1
        
        # Remove the key , by changing its value to -1
        self.lst[bucket][buck_item] =  -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
