# Time Complexity : O(1) for all operations
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach


class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # Maintain a tuple of (value, min_value) at each stack level
        self.stack.append((val, (min(self.stack[-1][1] if self.stack else val,val)))) 
        return []

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        return []

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1][0]

    def getMin(self):
        """
        :rtype: int
        """
        return self.stack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()