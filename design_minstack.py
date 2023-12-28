class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.min = int(sys.maxsize)
        self.minstack.append(self.min)
        
    def push(self, val: int) -> None:
        if val <= self.min:
            self.min = val
        self.stack.append(val)
        self.minstack.append(self.min)      

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.min = self.minstack[-1]

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()