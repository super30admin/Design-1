# Time Complexity: O(1)
# Space Complexity: O(1000)
# Did this code successfully run on Leetcode: 27/36 test cases passed
# Any problem you faced while coding this: No

# Your code here along with comments explaining your approach

# Considered a table of size 1000, created a hashing function of modulus. This hashing function places the key in the appropriate table index.

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.size_table = 1000
        self.table = [ [] for _ in range(self.size_table) ]
        
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_key = key % self.size_table
        self.table[hash_key] = [key,value]
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_key = key % self.size_table
        try:
            return self.table[hash_key][1]
        except:
            return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        
        hash_key = key % self.size_table
        self.table[hash_key] = []
        
