class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min or val <= self.min[-1]:
            self.min.append(val)
        

    def pop(self) -> None:
        if not self.stack:
            return None
        
        popVal = self.stack.pop()

        if popVal == self.min[-1]:
            self.min.pop()
        
        return popVal
        

    def top(self) -> int:
        if not self.stack:
            return None

        else:
            return self.stack[-1]
        

    def getMin(self) -> int:

        if not self.min:
            return None
        return self.min[-1]