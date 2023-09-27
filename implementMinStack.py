class MinStack(object):

    def __init__(self):
        self.stk = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if not self.stk:
            self.stk.append((val, val))
        else:
            min_val = min(val, self.stk[-1][1])
            self.stk.append((val, min_val))

    def pop(self):
        """
        :rtype: None
        """
        if self.stk:
            self.stk.pop()

    def top(self):
        """
        :rtype: int
        """
        if self.stk:
            return self.stk[-1][0]

    def getMin(self):
        """
        :rtype: int
        """
        if self.stk:
            return self.stk[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()