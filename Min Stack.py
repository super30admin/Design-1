# Time Complexity : Ammortized - O(1) 
# Space Complexity : O(n), where n is the size of stack
# Did this code successfully run on Leetcode : Yes , LC 155
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if self.min >= val:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        
    def pop(self):
        """
        :rtype: None
        """
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()
        
    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]      

    def getMin(self):
        """
        :rtype: int
        """
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()