class MinStack:

    def __init__(self):
        self.stack = list()
        self.stack_min_arr = list()

    def push(self, val: int) -> None:
        if len(self.stack) == 0:
            self.stack_min_arr.append(val)
        else:
            self.stack_min_arr.append(min(self.stack_min_arr[-1],val))
        self.stack.append(val)
        self.stack_min = min(val,self.top())
    def pop(self) -> None:
        if len(self.stack) > 0:
            self.stack.pop()
            self.stack_min_arr.pop()
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.stack_min_arr[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()