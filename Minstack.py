#// Time Complexity : O(1)
#// Space Complexity : O(n)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : No 

#// Your code here along with comments explaining your approach
#2 stacks - 1 for storing actual pushed values,
# 2 - for storing minimum values at each level,
# these 2 stacks must have 1:1 mapping
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        #updating min value
        if not self.min_stack:
            self.min_stack.append(val)
        else:
            top = self.min_stack[-1]
            if val < top:
                self.min_stack.append(val)
            else:
                self.min_stack.append(top)
        self.stack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        
        self.stack.pop()
        self.min_stack.pop()


    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()