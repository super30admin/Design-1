# Time Complexity: push, pop, top, getMin - O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class MinStack:

    # Initialize a stack for storing all the values and min values
    def __init__(self):
        self.stack = []
        self.minimum = float('inf')

    # push - append the prev min to the stack and update the new min. Then, append the curr val to the stack
    def push(self, val: int) -> None:
        if val <= self.minimum:
            self.stack.append(self.minimum)
            self.minimum = val
        self.stack.append(val)

    # pop - remove top element from the stack and if min is same as the removed element, update the min to prev min
    def pop(self) -> None:
        popped = self.stack.pop()
        if popped == self.minimum:
            self.minimum = self.stack.pop()

    # top - return the top element from stack
    def top(self) -> int:
        return self.stack[-1]

    # getMin - return min value
    def getMin(self) -> int:
        return self.minimum


