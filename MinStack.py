"""
Time Complexity
#   push(val)      -> O(1)
#   pop()          -> O(1)
#   top()          -> O(1)
#   getMin()       -> O(1)

Space Complexity : O(n)  [n -> number of elements stored in the stack]

Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# Using two stacks: one to store all values and another to track the current minimums which helps
# in keeping the getMin operation complexity to O(1)

"""


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_num = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_num or val <= self.min_num[-1]:
            self.min_num.append(val)

    def pop(self) -> None:
        if self.min_num[-1] == self.stack[-1]:
            self.min_num.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_num[-1]
