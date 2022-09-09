class MinStack(object):
    
    def __init__(self):
        self.stack = []
        self.Minstack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        val = min(val, self.Minstack[-1] if self.Minstack else val)
        self.Minstack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.Minstack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.Minstack[-1]

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()