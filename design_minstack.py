class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.mins= []
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.mins) == 0:
            self.mins.append(x)
        elif x < self.mins[-1]:
            self.mins.append(x)
        else:
            self.mins.append(self.mins[-1])

    def pop(self) -> None:
        if len(self.stack) == 0:
            return
        self.stack.pop()
        self.mins.pop()

    def top(self) -> int:
        if not len(self.stack):
            return None
        return self.stack[-1]

    def getMin(self) -> int:
        if not len(self.stack):
            return None
        return self.mins[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()