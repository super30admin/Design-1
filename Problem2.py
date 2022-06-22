import math
class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.min = math.inf
        self.minstack.append(self.min)
    def push(self, val: int) -> None:
        self.stack.append(val)
        if(val<self.min):
            self.minstack.append(val)
            self.min = val
        else :
            self.minstack.append(self.min)
    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.min = self.minstack[-1]

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