
# Time Complexity : Add:amortized O(1) Remove: O(n) Contain:O(n)
# Space Complexity : O(n)
# Code ran successfully run on Leetcode 
# Issue in finding out Space complexity. Also trying to optimize code to O(1)
# I am using simple hashing function which stores element in the index key % 100 of the list.
# Whole Hash table is a 2D list , with each bucket being 1D list. If element is already there is bucket, then another element 
# is appended in the 1D list.
class MyHashSet:

    def __init__(self):
        self.MAX = 100
        self.lst = [[] for i in range(self.MAX)]
        
    def get_Hash(self, key: int) -> int:
        hash_code = key % self.MAX
        return hash_code
    
    def add(self, key: int) -> None:
        if self.contains(key):
            return
        
        # Add key only if it doesn't exist
        hcode = self.get_Hash(key)
        self.lst[hcode].append(key)
        return

    def remove(self, key: int) -> None:
        if self.contains(key) is False:
            return
       
        # Remove the key , as it exists 
        hcode = self.get_Hash(key)
        self.lst[hcode].remove(key)
        return
    
    def contains(self, key: int) -> bool:
        
        """
        Returns true if this set contains the specified element
        """
        hcode = self.get_Hash(key)
        if key in self.lst[hcode] :
            return True
        else:
            return False
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
