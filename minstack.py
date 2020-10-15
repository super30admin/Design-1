class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.new = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if not self.new:
            self.new.append((x,x))
            return
        global_min = self.new[-1][1]
        self.new.append((x, min(x, global_min)))
        
    def pop(self):
        """
        :rtype: None
        """
        self.new.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.new[-1][0]

    def getMin(self):
        """
        :rtype: int
        """
        return self.new[-1][1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()