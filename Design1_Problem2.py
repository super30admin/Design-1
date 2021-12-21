# Time Complexity : O(1) for getting Min and push, O(n) for pop (because I am searching for the next min value if the popped element is the already existing minimum value)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach : a min value where I compare with the already existing minimum value and update it accordingly

import sys

class MinStack(object):

    def __init__(self):
        self.min_stack = []
        self.min = sys.maxint

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.min_stack.append(val)
        if self.min > val:
            self.min = val

    def pop(self):
        """
        :rtype: None
        """
        top = self.min_stack[-1]
        self.min_stack.pop()
        if top == self.min:
            self.min = sys.maxint
            for ind in range(len(self.min_stack)):
                if self.min > self.min_stack[ind]:
                    self.min = self.min_stack[ind]

    def top(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]
        
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