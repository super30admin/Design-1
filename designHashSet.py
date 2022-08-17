# Time Complexity : o(1) all operations
# Space Complexity : o(n) where n is the max length of hash set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Solution 1 - Using Linear Chaining
class MyHashSet:
    """
    We can create buckets(list of lists) and map all the input range to those buckets.
    input range = [0, 1000000]
    if we have 200 buckets, we can map input x, to (x % 200)th bucket
    """
    def __init__(self):
        self.buckets = [[] for _ in range(200)]
        
    def add(self, key: int) -> None:
        if not self.contains(key):
            bucket = key % 200
            self.buckets[bucket].append(key)
            
    def remove(self, key: int) -> None:
        bucket = key % 200
        if key in self.buckets[bucket]:
            self.buckets[bucket].remove(key)
            
    def contains(self, key: int) -> bool:
        bucket = key % 200
        return key in self.buckets[bucket]
    
# Solution 2 - Using Double Hashing

class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [[False for j in range(1000)] for i in range(1000)]
    
    def hash1(self, key:int) -> int:
        return key % self.buckets
    
    def hash2(self, key:int) -> int:
        return key // self.bucketItems
        
    def add(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if (self.storage[hash1] == None):
            if hash1 == 0:
                self.storage[hash1] = [False for _ in range(1001)]
            else:
                self.storage[hash1] = [False for _ in range(1000)]
        self.storage[hash1][hash2] = True
            
    def remove(self, key: int) -> None:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if (self.storage[hash1] == None): 
            return
        else:
            self.storage[hash1][hash2] = False
            
    def contains(self, key: int) -> bool:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if (self.storage[hash1] == None): 
            return False
        return self.storage[hash1][hash2]
    
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

