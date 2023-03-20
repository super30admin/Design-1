import math


class MinStack:

    def __init__(self):
        self.stack = []
        self.min = math.inf
    # pushing into stack takes O(1) time

    def push(self, val: int) -> None:
        if(val <= self.min):
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
    # poping from the stack takes O(1)

    def pop(self) -> None:
        temp = self.stack.pop()
        if(temp == self.min):
            self.min = self.stack.pop()
    # returning top and getting min also takes O(1) time

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
