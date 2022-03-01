# Time Complexity : O(1)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class MinStack(object):

    def __init__(self):
        self.stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        min_val = self.getMin()
        if self.getMin() is None or self.getMin() > val:
            min_val = val
        self.stack.append([val,min_val])

    def pop(self):
        """
        :rtype: None
        """
        if len(self.stack) == 0:
            print("Stack Underflow")
        else:
            return self.stack.pop()[0]
        

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            print("Stack Underflow")
        else:
            return self.stack[len(self.stack)-1][0]
        

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.stack) > 0:
            return self.stack[len(self.stack)-1][1]
        else:
            return None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()