"""/*
    ## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

    Approach
*/"""


class MinStack:

    def __init__(self):
        self.stack = [] 
        self.minStack = []  # holds min of all the prev entries at a index

    def push(self, val: int) -> None:
        # handling case if stack is empty
        self.minStack.append(min(val, self.minStack[-1] if self.minStack else val)) 
        self.stack.append(val)
    
    def pop(self) -> None:
        recent_val = self.stack[-1]
        # set minStack and stack
        self.minStack = self.minStack[:-1]
        self.stack = self.stack[:-1]
        return recent_val
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()