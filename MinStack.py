import sys
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.inStack=[]
        self.minStack=[]
        self.minimum=sys.maxsize
        self.minStack.append(self.minimum)
    def push(self, x: int) -> None:
        self.minimum=min(self.minimum,x)
        self.inStack.append(x)
        self.minStack.append(self.minimum)
    def pop(self) -> None:
        if(len(self.inStack)!=0):
            self.inStack.pop()
        if(len(self.minStack)!=0):
            self.minStack.pop()
        self.minimum=self.minStack[-1]    

    def top(self) -> int:
        if(len(self.inStack)!=0):
            return self.inStack[-1]
        

    def getMin(self) -> int:
        return self.minimum


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
