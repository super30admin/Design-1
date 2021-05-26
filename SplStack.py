#Time complexity for each operation: O(1)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minStack = []
        self.globMin = float('inf')
        self.minStack.append(self.globMin)

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if val < self.globMin:
            self.minStack.append(val)
            self.globMin = val
        else:
            self.minStack.append(self.globMin)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minStack.pop()
        self.globMin = self.minStack[-1]

        
    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            return None
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.globMin


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()