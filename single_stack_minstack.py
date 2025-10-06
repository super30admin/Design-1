class MinStack:

    def __init__(self):
        self.mainstack = []

    def push(self, val: int) -> None:
        if len(self.mainstack) == 0:
            self.min_val = val
        else:
            self.min_val = min(self.mainstack[-1], val)
        self.mainstack.append(val)
        self.mainstack.append(self.min_val)

        return self.mainstack

    def pop(self) -> None:

        if self.mainstack is not None:
            del self.mainstack[-1]
            del self.mainstack[-1]

    def top(self) -> int:
        if self.mainstack:
            return self.mainstack[-2]

    def getMin(self) -> int:
        if self.mainstack:
            return self.mainstack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()