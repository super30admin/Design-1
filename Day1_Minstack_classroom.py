class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = int(sys.maxsize)
        self.minStack.append(self.min)


    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if val <= self.min:
            self.min = val

        self.minstack.append(self.min)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minstack.pop()
        self.min = self.minstack[-1]
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1], self.minStack[-1]
    

    def getMin(self):
        """
        :rtype: int
        """