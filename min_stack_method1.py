# Maintain min integer
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = sys.maxint
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if self.min >=  x:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)
            
    def pop(self):
        """
        :rtype: None
        """
        popped = self.stack.pop()
        if popped == self.min:
            self.min = self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[len(self.stack) - 1]

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
