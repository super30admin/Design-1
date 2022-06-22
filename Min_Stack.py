class MinStack:

    def __init__(self):
        self.stack=[]
        self.minimum=math.inf
        

    def push(self, val: int) -> None:
        if val<=self.minimum:
            self.stack.append(self.minimum)
            self.minimum=val
            
        self.stack.append(val)
        

    def pop(self) -> None:
        
        if self.minimum==self.stack.pop():
            self.minimum=self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minimum

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()