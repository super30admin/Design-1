class MinStack:

    def __init__(self):
        self.min = 2**31
        self.stack = []
        

    def push(self, val: int) -> None:
        if(val <=self.min):
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)        
        

    def pop(self) -> None:
        if(self.min == self.stack.pop()):
            self.min = self.stack.pop()        

    def top(self) -> int:
        if(len(self.stack)>0):
            return self.stack[-1]
        else:
            return None
        

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(21)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()