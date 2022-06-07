# https://leetcode.com/problems/design-hashset/
# Time Complexity : O(1) for all of the functions
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach


# Using double hashing
# using None list of size sqrt of input size 10e6 and each list index will 
# have boolean array of size sqrt 10e6
# For every key, use hash1 to find location in primary list
# And use hash2 for location in secondary list 
class MyHashSet:

    def __init__(self):
        # since input can be upto 10e6 - we take sqrt(10e6) which is 10e3
        self.bucket = 5
        self.bucketItems = 5
        self.list = [None] * self.bucket   # init an empty list with None values

    def hash1(self, key):
        return key % self.bucket
    
    def hash2(self, key):
        return key // self.bucketItems # use integer division

    def add(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if not self.list[h1]:  # meaning its None
            self.list[h1] = [False] * self.bucketItems  # using boolean to tell False means missing, True means present
            if h1 == 0: # handle edge case where we can get 1001 items but bucket is only 1000
                self.list[h1].append(False)
        
        self.list[h1][h2] = True
        

    def remove(self, key: int) -> None:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.list[h1]:
            self.list[h1][h2] = False
        

    def contains(self, key: int) -> bool:
        h1 = self.hash1(key)
        h2 = self.hash2(key)
        if self.list[h1]:
            if self.list[h1][h2]:
                return True
        return False
    
    def __str__(self):
        return str(self.list)


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
key = 5
obj.add(key)
# obj.remove(key)
print(obj.contains(key))
print(obj)