class MinStack:

    def __init__(self):
        self.mainstack = []
        self.child_stack = []

    def push(self, val: int) -> None:
        self.mainstack.append(val)
        if not self.child_stack:
            self.min_val = val
        else:
            self.min_val = min(self.child_stack[-1], val)
        self.child_stack.append(self.min_val)

        return self.mainstack

    def pop(self) -> None:

        if self.mainstack is not None:
            del self.mainstack[-1]
            del self.child_stack[-1]

    def top(self) -> int:
        if self.mainstack:
            return self.mainstack[-1]

    def getMin(self) -> int:
        if self.child_stack:
            return self.child_stack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()