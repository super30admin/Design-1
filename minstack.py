class MinStack:
    def __init__(self):
        self.s=[]
        self.min=[]
    def push(self, val: int) -> None:
        self.s.append(val)
        if not self.min:
            self.min.append(val)
        elif self.min[-1] < val:
            self.min.append(self.min[-1])
        else:
            self.min.append(val)
    def pop(self) -> None:
        self.s.pop()
        self.min.pop()
    def top(self) -> int:
        return self.s[-1]
    def getMin(self) -> int:
        return self.min[-1]