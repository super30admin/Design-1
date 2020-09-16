"""
Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : Yes, but struggled in C++ so switched to python
"""

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min = float("inf")
        self.stack = []

    def push(self, x: int) -> None:

        if(x <= self.min):
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:

        if(self.stack.pop() == self.min):
            self.min = self.stack.pop()

    def top(self) -> int:

        return self.stack[-1]


    def getMin(self) -> int:
        return self.min
