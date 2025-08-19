# Time Complexity : O(1)
# Space Complexity : O(N) where N is the number of elements in the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using two stacks, one for the main stack and one for the minimum values. When I push a new value, 
# I also push it onto the min stack if it is smaller than the current minimum.
# When I pop a value, I check if it is the current minimum and pop it from the min stack as well.
# To get the minimum value, I simply return the top value of the min stack.

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []

    def push(self, val: int) -> None:
        if not self.min or self.min[-1] >= val:
            self.min.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.min[-1] == self.stack[-1]:
            self.min.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min[-1]