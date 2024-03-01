# TC - O(1) SC = O(n)
import math


class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.minval = math.inf
        self.minstack.append(self.minval)

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.minval = min(self.minval, self.stack[-1])
        self.minstack.append(self.minval)

    def pop(self) -> None:

        if self.stack == None:
            return None
        else:

            self.stack = self.stack[:-1]
            self.minstack = self.minstack[:-1]
            self.minval = self.minstack[-1]

    def top(self) -> int:
        if self.stack == None:
            return None
        else:
            return self.stack[-1]

    def getMin(self) -> int:

        return self.minval


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
