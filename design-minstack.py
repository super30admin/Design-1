class MinStack(object):

    def __init__(self):
        self.stack = [] 
        self.minstack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)

        #if minstack is empty
        if not self.minstack:
            self.minstack.append(val)
        #if minstack is not empty
        elif self.minstack[-1] < val:
            self.minstack.append(self.minstack[-1])
        else: # if val is less than min
            self.minstack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minstack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()