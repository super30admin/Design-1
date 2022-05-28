#implementing a stack which gives min for every operation
#Using a single stack
#space complexity is O(n)
#time complexity is O(1)
import sys


class MinStack(object):

    def __init__(self):
        self.stack=[]
        self.minval=sys.maxint

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val<=self.minval :
            self.stack.append(self.minval)
            self.minval=val
        self.stack.append(val)


    def pop(self):
        """
        :rtype: None
        """
        if self.stack.pop()==self.minval:
            self.minval=self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minval


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()