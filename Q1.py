# Time Complexity : Every operation is done in O(1) time
# Space Complexity : O(n * m) where n is the unique number of keys and m is the size of the buckets
# Did this code successfully run on Leetcode : Yes  
# Any problem you faced while coding this : No  

# Three line explaination of the code: This implements a hash set using two-level hashing. hashfunc1 maps keys to buckets (value % 1000), while hashfunc2 maps keys to positions within buckets (value // 1000). Buckets initialize lazily ([False] * 1001) when first accessed, tracking key presence with boolean flags. O(1) average-time operations: add()/remove()/contains() directly access the bucket and position via the two hash functions.

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.hashSet = [None] * self.size

    def add(self, key: int) -> None:
        i = self.hashfunc1(key)
        j = self.hashfunc2(key)
        if self.hashSet[i] is None:
            self.hashSet[i] = [False] * (self.size + 1)
        
        self.hashSet[i][j] = True

    def remove(self, key: int) -> None:
        i = self.hashfunc1(key)
        j = self.hashfunc2(key)
        if self.hashSet[i] is not None:
            self.hashSet[i][j] = False

    def contains(self, key: int) -> bool:
        i = self.hashfunc1(key)
        j = self.hashfunc2(key)
        return self.hashSet[i] is not None and self.hashSet[i][j]     


    def hashfunc1(self, value):
        return value % self.size
    
    def hashfunc2(self, value):
        return value // self.size

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)