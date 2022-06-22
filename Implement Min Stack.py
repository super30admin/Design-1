class MinStack:

    def __init__(self):
        self.stack = []
        
    def push(self, x: int) -> None:
        if self.stack:
            self.stack.append(min(self.stack[-2],x))
        else:
            self.stack.append(x)
        self.stack.append(x)
        
    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            self.stack.pop()
        
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.stack[-2]