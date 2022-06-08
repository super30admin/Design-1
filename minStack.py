class MinStack:

    def __init__(self):
        self.l = list()
        self.min = list()

    def push(self, val: int) -> None:
        self.l.append(val)
        if not self.min or val <= self.min[-1]:
            self.min.append(val)

    def pop(self) -> None:

        if self.min[-1] == self.l[-1]:
            self.min.pop()

        self.l.pop()

    def top(self) -> int:
        return self.l[-1]

    def getMin(self) -> int:
        return self.min[-1] if self.min else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()