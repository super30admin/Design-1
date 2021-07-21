'''Design Hash Map'''
# Time Complexity : O(1)
# Space Complexity : O(N), in the given case 10^6
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
"""Implemented double hashing
For each index, secondary hash with a different hashing function gives unique and exact index for item"""
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.div = 1000  # square root of the range of values
        self.primary = [None for _ in range(1000)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        idx = key % self.div
        sec_idx = key // self.div
        
        if not self.primary[idx]:
            if idx == 0:
                self.primary[0] = [None for _ in range(self.div+1)]
            else:
                self.primary[idx] = [None for _ in range(self.div)]
        self.primary[idx][sec_idx] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx = key % self.div
        sec_idx = key // self.div
        return self.primary[idx][sec_idx] if self.primary[idx] and self.primary[idx][sec_idx]!=None else -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx = key % self.div
        sec_idx = key // self.div
        if self.primary[idx] and self.primary[idx][sec_idx]:
            self.primary[idx][sec_idx] = None        
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)    
