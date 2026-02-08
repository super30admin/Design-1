## Problem 2:
## Design MinStack (https://leetcode.com/problems/min-stack/)


class MinStack:

    def __init__(self):
        self.main_stack = []
        self.min_stack = []
        self.min_val = float('inf')
        self.min_stack.append(self.min_val)

    def push(self, val: int) -> None:
        self.min_val = min(self.min_val,val)
        self.main_stack.append(val)
        self.min_stack.append(self.min_val)
        

    def pop(self) -> None:
        self.main_stack.pop()
        self.min_stack.pop()
        self.min_val = self.min_stack[-1]

    def top(self) -> int:
        return self.main_stack[-1]

    def getMin(self) -> int:
        min_val = self.min_stack[0]
        for i in range(1,len(self.min_stack)):
            if self.min_stack[i] < min_val:
                min_val = self.min_stack[i]
        return min_val

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()