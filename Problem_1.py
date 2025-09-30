#Time Complexity : O(1) for all functions
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :NA
class MyHashSet:

    def __init__(self):
        # Initialize hash set array of size 1,000,001 with all values False
        # Each index represents a key, and True means the key exists in the set
        self.hashset = [False] * 1000001

    def add(self, key: int) -> None:
        # Mark the key as present in the hash set
        self.hashset[key] = True

    def remove(self, key: int) -> None:
        # Mark the key as not present in the hash set
        self.hashset[key] = False

    def contains(self, key: int) -> bool:
        # Return True if the key exists in the hash set, else False
        return self.hashset[key]
# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(2)
obj.add(3)
obj.add(25)
obj.add(67)
obj.remove(2)
param_3 = obj.contains(3)