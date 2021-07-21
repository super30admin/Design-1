# Time Complexity : 
#   All time complexities are O(1) since we directly access the indexes and we set/get the value.
#   Put : O(1)
#   Get : O(1)
#   Remove : O(1)
# Space Complexity : O(root(n)*(root(n))) = O(n) where n is the maximum value needed to be stored.
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this :
# The program is slow. Even with double hashing, the implementation took 1.4 seconds to pass all testcases

# Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1001
        self.table = [[-1 for _ in range(self.size)] for _ in range(self.size)]
    def contains():
        '''contains Function definition. '''
        pass

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.table[key%self.size][key//self.size] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.table[key%self.size][key//self.size] 

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key.
        """
        self.table[key%self.size][key//self.size] = -1

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)