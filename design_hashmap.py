# Time Complexity : O(n) = log n
# Space Complexity : m where m is max number of elements possible, 1000000 as per leetcode constraints
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Some minor silly mistakes.


# Your code here along with comments explaining your approach
# I tried a strict complete binary tree approach instead of standard linked lists in an array approach because I could not
# determine what would be the ideal length of the array. I assumed this would be the fastest approach since all the operations 
# would take h steps i.e. height of the tree which at max can be 20. But my answer is faster than only 19% of submission on leetcode.
# My approach most often leads to sacrificing space for time.

class TreeNode:
    def __init__(self, data=-1):
        self.data = data
        self.left = None
        self.right = None
    
    @staticmethod
    def get_path(key):
        divisor = key
        result = []
        while divisor > 1:
            remainder = divisor % 2
            result.append(remainder)
            divisor = divisor // 2
        return reversed(result)
    
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TreeNode()
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        key+=1
        path = TreeNode.get_path(key)
        current = self.root
        for p in path:
            if p == 0:
                if not current.left:
                    current.left = TreeNode(-1)
                current = current.left
            else:
                if not current.right:
                    current.right = TreeNode(-1)
                current = current.right
        current.data = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        key+=1
        path = TreeNode.get_path(key)
        current = self.root
        for p in path:
            if p == 0:
                if not current.left:
                    return -1
                current = current.left
            else:
                if not current.right:
                    return -1
                current = current.right
        return current.data

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        key+=1
        path = TreeNode.get_path(key)
        current = self.root
        for p in path:
            if p == 0:
                if not current.left:
                    return -1
                current = current.left
            else:
                if not current.right:
                    return -1
                current = current.right
        current.data = -1

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(key,value)
param_2 = obj.get(key)
obj.remove(key)
