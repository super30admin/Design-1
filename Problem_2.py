class MinStack:

    def __init__(self):

        self.stack = []
        self.currentMin = float('inf')
        self.prevMins = []
        
    def push(self, x: int) -> None:
        self.stack.append(x)
        if x <= self.currentMin:
            self.prevMins.append(self.currentMin)
            self.currentMin = x

    def pop(self) -> None:
        if self.stack[-1] == self.currentMin:
            self.currentMin = self.prevMins.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.currentMin