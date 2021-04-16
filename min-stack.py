# Time Complexity : O(1)
# Space Complexity : O(n), where n is the number of elements in the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import sys


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = [sys.maxsize]

    def push(self, x: int) -> None:
        self.stack.append(x)
        self.min_stack.append(min(x, self.min_stack[-1]))

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
