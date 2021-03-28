import sys

"""
Code successfully accepted on Leetcode.
Time complexity is O(1) for push, pop, top and getMin operations. 
Space is complexity is O(n), which we use to maintain another stack for storing min elements
"""
class MinStack(object):
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if(len(self.stack) == 0):
            self.minStack.append(x)
        else:
            self.minStack.append(min(x,self.getMin()))
        self.stack.append(x)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minStack.pop()

    def top(self):
        """
        :rtype: int
        """
        if(len(self.stack)!=0):
            return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if(len(self.stack) == 0):
            return sys.maxint
        else:
            return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(3)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()