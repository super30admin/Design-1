"""
Time Complexity:
    - push - O(1)
    - pop - O(1)
    - top - O(1)
    - getmin - O(1)
Space Complexity:
    - Size of the array - dynamic O(n)
YES, The code successfully ran on Leetcode
The problem was on how to have the minimum of the array at the time the x was added.

Approach - My approach is pretty clever, I wanted to store the minimum of the array at every moment of
addition therefore, i went with the idea of adding the current min with the push if applicable
"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.cmin = None

    def push(self, val: int) -> None:
        if len(self.stack) == 0:
            self.cmin = val
        else:
            if val <= self.cmin:
                self.stack.append(self.cmin)
                self.cmin = val
        self.stack.append(val)

    def pop(self) -> None:
        t = self.stack.pop()
        if t == self.cmin:
            if len(self.stack) > 1:
                self.cmin = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.cmin
