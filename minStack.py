'''
// Time Complexity : O(n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach"
Use two stacks so that we can keep track of the min in one of the stack,
based on the comparisons we will update the stack values, so that we can
achieve the stack operations in O(1)
'''
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min_stk = []
        self.stk = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.stk.append(x)
        if not self.min_stk or self.min_stk[-1] >= x:
            self.min_stk.append(x)


    def pop(self):
        """
        :rtype: void
        """
        t = self.stk.pop()
        if self.min_stk[-1] == t:
            self.min_stk.pop()


    def top(self):
        """
        :rtype: int
        """
        return self.stk[-1]


    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stk[-1]