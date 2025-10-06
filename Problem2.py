class MinStack:

    def __init__(self):
        self.minS = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if val <= self.min:
            self.minS.append(self.min)
            self.min = val
            self.minS.append(val)
        else:
            self.minS.append(val)
    def pop(self) -> None:
        a = self.minS.pop()
        if a == self.min:
            self.min = self.minS.pop()

    def top(self) -> int:
        return self.minS[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
