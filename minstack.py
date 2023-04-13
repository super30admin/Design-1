import sys
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = sys.maxsize
    def push(self, val: int) -> None:
        self.stack.append(val)

        if(val <= self.min):
            self.min = val  

        self.minStack.append(self.min)
    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        if self.minStack:
            self.min = self.minStack[len(self.minStack) - 1]
        else:
            self.min = sys.maxsize
    def top(self) -> int:
        if (self.stack):
            return self.stack[len(self.stack) - 1]
        
    def getMin(self) -> int:
        return self.min
      


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

#TestCase
#["MinStack","push","push","push","getMin","pop","top","getMin"]
#[[],[-2],[0],[-3],[],[],[],[]]