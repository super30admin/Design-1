class MinStack:

    def __init__(self):
        self.stack=[]
        self.minStack=[]
        self.Min=int(sys.maxsize)
        self.minStack.append(self.Min)
        

    def push(self, val: int) -> None:
        if val<=self.Min:
            self.Min=val
        self.stack.append(val)
        self.minStack.append(self.Min)
    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.Min=self.minStack[-1]
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.Min
        