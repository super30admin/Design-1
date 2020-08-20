class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minStack = []
        self.min = float('inf')
        
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if x <= self.min: 
            self.minStack.append(self.min)
            self.min = x
        self.minStack.append(x);

    def pop(self):
        """
        :rtype: None
        """
        if self.min == self.minStack[-1]:
            self.minStack.pop()
            self.min = self.minStack[-1]
        self.minStack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.minStack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
