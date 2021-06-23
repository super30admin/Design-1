from collections import deque
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = deque()
        self.min_stack = deque()
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if len(self.stack) == 0:
            self.stack.append(x)
            self.min_stack.append(x)
        else:
            self.stack.append(x)
            if self.min_stack[-1]>=x:
                self.min_stack.append(x)
        
        

    def pop(self):
        """
        :rtype: None
        """
        val = self.stack.pop()
        if self.min_stack[-1] == val:
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
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()