class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minstack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if len(self.minstack) == 0 or val <= self.minstack[len(self.minstack) - 1]:
            self.minstack.append(val)
        self.stack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        if len(self.stack) > 0:
            del self.stack[-1]
        if len(self.minstack) > 0:
            del self.minstack[-1]
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return min(self.stack)
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()