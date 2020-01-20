class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if self.stack:
			self.stack.append(min(self.stack[-2], x))
        else:
            self.stack.append(x)
        self.stack.append(x)

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.stack[-2]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()