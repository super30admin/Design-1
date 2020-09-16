class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.ms = []
        self.min=sys.maxint
        self.t = -1
        
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if x<=self.min:
            self.ms.append(self.min)
            self.t+=1
            self.ms.append(x)
            self.t+=1
            self.min = x
        else:
            self.ms.append(x)
            self.t+=1

    def pop(self):
        """
        :rtype: None
        """
        if self.t==-1:
            return None
        if self.ms.pop()==self.min:
            self.min=self.ms.pop()
            self.t-=2
        else:
            self.t-=1

    def top(self):
        """
        :rtype: int
        """
        if self.t==-1:
            return None
        else:
            return self.ms[self.t]

    def getMin(self):
        """
        :rtype: int
        """
        if self.t==-1:
            return 0
        else:
            return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()