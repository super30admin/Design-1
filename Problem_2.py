# // Time Complexity :O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

import math
class MinStack:

    def __init__(self):
        self.stack = []
        self.minValue = math.inf
        

    def push(self, val: int) -> None:
        if len(self.stack) == 0:
            self.minValue = val
        if(val <= self.minValue):
            self.stack.append(self.minValue)
            self.minValue = val
        self.stack.append(val)
            
    def pop(self) -> None:
        if self.stack[-1] == self.minValue:
            self.stack.pop()
            self.minValue = self.stack.pop()
            print(self.stack)
        else:
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