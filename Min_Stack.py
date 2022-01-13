# Time complexity : All the operations have O(1) per operation 
# space : Stack is used : O(n)

import sys

class MinStack:

    
    def __init__(self):
        self.minValue = sys.maxsize
        self.stack = [self.minValue]

    def push(self, val: int) -> None:
        
        if(val <= self.minValue):
            # mark the range
            self.stack.append(self.minValue)
            self.minValue = val
        
        self.stack.append(val)

    def pop(self) -> None:
        
        temp = self.stack.pop()
        # demark the range : so pop two elements
        if self.minValue == temp :
            # second min value (-2 -1) -2 must be removed
            self.minValue = self.stack[-1]
            self.stack.pop()
    
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minValue


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()