// Time Complexity : O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        self.stack = [] 
        self.MinStack= []

    def push(self, val: int) -> None:
        if not self.MinStack or val <= self.MinStack[-1]:
            self.MinStack.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.stack[-1] == self.MinStack[-1]:
            self.MinStack.pop()
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.MinStack[-1]
