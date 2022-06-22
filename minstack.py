class MinStack:

    def __init__(self):
        self.stack = []
        self.minvalue = sys.maxsize

    def push(self, val: int) -> None:
        if(val <= self.minvalue):
            self.stack.append(self.minvalue)
            self.minvalue = val
        self.stack.append(val)
    

    def pop(self) -> None:
        if(self.stack[-1] == self.minvalue):
            self.stack.pop()
            self.minvalue = self.stack.pop()
            
        else:
            self.stack.pop()
        
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minvalue
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()