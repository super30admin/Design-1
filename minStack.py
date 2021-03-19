class MinStack:
    def __init__(self):
        self.stack=[]
        self.mini=sys.maxsize
        
    def push(self, val: int) -> None:
        if(val<=self.mini):
            self.stack.append(self.mini)
            self.mini = val
        self.stack.append(val)
        print(self.mini)
            
    def pop(self) -> None:
        popped =self.stack.pop()
        if (popped ==self.mini):
            self.mini=self.stack.pop()
            
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        
        return self.mini
        
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()