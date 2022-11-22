class MinStack:

    def __init__(self):
        self.stack = []
        self.mini = float("inf")

    def push(self, val: int) -> None:
        
        if self.mini >= val:
            self.stack.append(self.mini)
            self.mini = val
        self.stack.append(val)

    def pop(self) -> None:
        
        temp = self.stack.pop()
        if self.mini == temp:
            self.mini = self.stack.pop()        

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