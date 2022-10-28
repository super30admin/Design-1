// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :No 
// Any problem you faced while coding this :
yes it fails for the input above 1000000


// Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.array = [-1 for i in range(1000000)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.array[key]=value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.array[key]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.array[key]=-1