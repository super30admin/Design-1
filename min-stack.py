# Problem 2: Min Stack
# Time Complexity: O(1) for all operations - push, pop, top, getMin
# Space Complexity: O(n) 
# Did this code successfully run on Leetcode: YES, but needed to take reference from solution to understand the approach
# Any problem you faced while coding this: Understanding the two stack approach

class MinStack:
    def __init__(self):
        self.main_stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.main_stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])

    def pop(self) -> None:
        self.main_stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.main_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]