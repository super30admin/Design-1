class MinStack:

    def __init__(self):
        self.stack = []
        self.minst = []
        self.min = float('inf')
        self.minst.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(val,self.min)
        self.stack.append(val)
        self.minst.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minst.pop()
        self.min = self.minst[-1]

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