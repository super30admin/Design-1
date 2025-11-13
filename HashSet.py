# Time Complexity: O(1)
# Space Complexity: O(primaryBuckets × secondaryBuckets)
# Did this code successfully run on LeetCode: Yes
# Any problem you faced while coding this: I had some issues with the syntax; other than that, I am good


"""
Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(key)
obj.remove(key)
param_3 = obj.contains(key)
"""


# Your code here along with comments explaining your approach:
# For the add function, I checked if there are any elements in that index in the first array.
# If not, I initialized an array and kept that particular element in its hashed index.
# For remove and contains, I checked whether that index exists.
# If it exists, I removed it; and for contains, I return True or False.

class MyHashSet:
    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.storage = [None]* self.primaryBuckets
    def hash1(self,key):
        return key % self.primaryBuckets
    def hash2(self,key):
        return key // self.secondaryBuckets

    def add(self, key: int) -> None:
        hash_1 = self.hash1(key)
        hash_2 = self.hash2(key)
        if (self.storage[hash_1] == None):
            if (hash_1 == 0):
                self.storage[hash_1] = [False]* (self.secondaryBuckets+1)
            else:
                self.storage[hash_1] = [False]* (self.secondaryBuckets)
        self.storage[hash_1][hash_2] = True
        
    def remove(self, key: int) -> None:
        hash_1 = self.hash1(key)
        hash_2 = self.hash2(key)
        if self.storage[hash_1] == None:
            return
        self.storage[hash_1][hash_2] = False
        

    def contains(self, key: int) -> bool:
        hash_1 =  self.hash1(key)
        hash_2 = self.hash2(key)
        if self.storage[hash_1] == None:
            return False
        return self.storage[hash_1][hash_2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)