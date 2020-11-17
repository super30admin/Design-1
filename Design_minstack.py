class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min) == 0:
            self.min.append(x)
        else:
            if x <= self.min[-1]:
                self.min.append(x)
            else:
                self.min.append(self.min[-1])
        

    def pop(self) -> None:
        if len(self.stack) > 0:
            self.min.pop()
            self.stack.pop()
        
        

    def top(self) -> int:
        if len(self.stack) > 0:
            return self.stack[-1]
        else:
            return -1
        

    def getMin(self) -> int:
        if len(self.min) > 0:
            return self.min[-1]
        else:
            return -1