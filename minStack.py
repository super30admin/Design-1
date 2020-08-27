# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if not self.minStack or x < self.minStack[-1][0]:
            self.minStack.append([x, 1])
        elif x == self.minStack[-1][0]:
            self.minStack[-1][1] += 1
        

    def pop(self) -> None:
        if self.minStack[-1][0] == self.stack[-1]:
            self.minStack[-1][1] -= 1
        
        if self.minStack[-1][1] == 0:
            self.minStack.pop()
        
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1][0] 