# Time Complexity :
# Space Complexity : 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Unsure about deriving time and space complexity


# Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = []
        self.data = [None] * 1000000
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.data[key] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if self.data[key] is None:
            return -1
        else:
            return self.data[key]
        
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.data[key] = None