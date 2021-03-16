class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if not self.min:
            self.min.append(x)
        else:
            val_1 = min(self.min[-1], x)
            self.min.append(val_1)

    def pop(self) -> None:
        ele = self.stack.pop()
        if self.min[-1] == ele:
            self.min.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min[-1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()