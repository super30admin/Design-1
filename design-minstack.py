class MinStack(object):

    def __init__(self):
        self.stack=[]
        self.minimun=9999999999

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val<=self.minimun:
            self.stack.append(self.minimun)
            self.minimun=val
        self.stack.append(val)
        
    def pop(self):
        """
        :rtype: None
        """ 
        if self.stack.pop()==self.minimun:
            self.minimun=self.stack.pop()
        
        

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack)!=0:
            return self.stack[len(self.stack)-1]
        else:
            return None
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minimun
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()