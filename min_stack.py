import sys

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min=sys.maxsize

    def push(self, x: int) -> None:
        """
        if incoming is less or equal to min than push(min) -> min=incoming -> push(incoming)
        """
        if x > self.min:
            self.stack.append(x)
        else:
            self.stack.append(self.min)
            self.min=x
            self.stack.append(x)

    def pop(self) -> None:
        if self.isnotEmpty():
            if self.stack[-1] == self.min:
                self.stack.pop()
                self.min=self.stack[-1]
                self.stack.pop()
            else:
                self.stack.pop()

    def isnotEmpty(self):
        if len(self.stack) != 0:
            return True
        else:
            return False

    def top(self) -> int:
        if self.isnotEmpty():
            return self.stack[-1]
        else:
            return -1

    def getMin(self) -> int:
        if self.isnotEmpty():
            return self.min
        else:
            return -1


# Your MinStack object will be instantiated and called as such:

obj = MinStack()
obj.push(9)
obj.push(2)
obj.push(4)
obj.pop()
obj.push(2)
obj.pop()
obj.push(1)
obj.pop()
obj.push(3)
obj.push(2)
obj.push(3)
obj.push(7)

param_3 = obj.top()
param_4 = obj.getMin()

print(param_3)
print(param_4)
