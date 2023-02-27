class MinStack(object):

    def __init__(self):
        self.stack= []
        self.min_stack= []
        self.counter= -1
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # Append value to stack.
        self.stack.append(val)

        # Compute min value and push to min stack.
        if self.counter== -1:
            self.min_stack.append(val)
            self.counter+=1
            return
        
        if val< self.min_stack[self.counter]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[self.counter])

        self.counter+=1
        

    def pop(self):
        """
        :rtype: None
        """
        self.counter-=1
        self.stack.pop()
        self.min_stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        
        return self.min_stack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()