class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = int(sys.maxsize)


    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        popped = self.stack.pop()
        if popped ==  self.min:
            self.min = self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1] 
    

    def getMin(self):
        """
        :rtype: int
        """
        return self.min