# Time Complexity : Mentioned near each problem. Overall is O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        
        self.stack = []
        self.smallpos = -1
        
    def push(self, val: int) -> None: # O(1) because of min()
        if len(self.stack) == 0:
            self.stack.append(val)
            self.smallpos = 0
        else:
            if val < self.stack[self.smallpos]:
                self.stack.append(val)
                self.smallpos = len(self.stack) - 1
            else:
                self.stack.append(val)

    def pop(self) -> None: #O(n) because of min()
        if len(self.stack):
            self.stack.pop()
            if len(self.stack):
                self.smallpos = self.stack.index(min(self.stack))
            else:
                self.smallpos = -1
            
        else:
            pass

    def top(self) -> int: #O(1)
        if len(self.stack):
            return self.stack[-1]
        else:
            return -1

    def getMin(self) -> int: # O(1)
        if len(self.stack):
            return self.stack[self.smallpos]
        else:
            return -1
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
param_4 = obj.getMin()
print(param_4)
obj.pop()
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)