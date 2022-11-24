class MinStack:
    stack=[]
    min_stack=[]
    def __init__(self):
        self.min_1=float('inf')
        self.min_stack.append(self.min_1)
    def push(self, val: int) -> None:
        self.min_1=min(self.min_1,val)
        self.stack.append(val)
        self.min_stack.append(self.min_1)
        

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()
        self.min_1=self.min_stack[-1]



    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min_1
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()