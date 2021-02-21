class MinStack:
    min = float('inf')
    stack = []

    def __init__(self):
        self.min = float('inf')
        self.stack = []
        """
        initialize your data structure here.
        """

    def push(self, x: int) -> None:
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:
        top = self.stack[-1]
        self.stack.pop()
        if top == self.min:
            self.min = self.stack[-1]
            self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


m = MinStack()
m.push(-2)
m.push(0)
m.push(-3)
print(m.getMin())
m.pop()
print(m.top())
print(m.getMin())
