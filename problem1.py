# Time Complexity :
# add(): O(1)
# remove(): O(1)
# contains(): O(1)

# Space Complexity : O(N) N->Size of the input 

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#Approach: Implemented Double Hashing Technique where hash fucntion 1 will determine the primary bucket (key % size)
# and hash fucntion 2 will find the position in that bucket

#Each Operation maps the key using these two indexes by indexing directly into the structure

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.buckets = 1001
        self.storage = [None]*self.size

    def hash1(self, key):
        return key % self.size

    def hash2(self, key):
        return key // self.buckets
        

    def add(self, key: int):
        index1 = self.hash1(key)
        if self.storage[index1] == None:
            self.storage[index1] = [False]*self.buckets
        index2 = self.hash2(key)
        self.storage[index1][index2] = True

    def remove(self, key: int):
        index1 = self.hash1(key)
        if self.storage[index1] == None:
            return
        index2 = self.hash2(key)
        self.storage[index1][index2] = False

    def contains(self, key: int):
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        return self.storage[index1] != None and self.storage[index1][index2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)