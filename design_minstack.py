class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        # time complexity O(1)
        if not self.stack:
            self.stack.append([val, val])
            return
        self.stack.append([val, min(self.stack[-1][1], val)])

    def pop(self) -> None:
        # time complexity O(1)
        self.stack.pop(-1)

    def top(self) -> int:
        # time complexity O(1)
        return self.stack[-1][0]

    def getMin(self) -> int:
        # time complexity O(1)
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()