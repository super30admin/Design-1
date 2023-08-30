# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
# we are using a single stack to define this min stack. 
# PUSH: For the push operation, we append to the stack the existing min_val along with the val if it is getting changed. It helps to keep track of the previous min_val
# POP: if the value getting popped is same as the min_val, then we pop twice, and set the min_val to the previous one
# TOP: simply returns the top element of the stack
# GetMIN: returns the min_val as determined by the other operations


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_val = float(inf)

    def push(self, val: int) -> None:
        if self.min_val >= val:
            self.stack.append(self.min_val)
            self.min_val = val
        self.stack.append(val)

    def pop(self) -> None:
        if self.stack.pop() == self.min_val:
            self.min_val = self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min_val