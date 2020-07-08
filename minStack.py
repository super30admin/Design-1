
# Time Complexity : O(1) for all the functions
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No.


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minimum = float('inf')

    def push(self, x: int) -> None:
        if x <= self.minimum:
            self.stack.append(self.minimum)
            self.minimum = x
        self.stack.append(x)

    def pop(self) -> None:
        popped = self.stack.pop()

        if popped == self.minimum:
            self.minimum = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minimum
