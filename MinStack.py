"""
Time Complexity:
    * __init__  : O(1)
    * push      : O(1)
    * pop       : O(n)
    * top       : O(1)
    * getMin    : O(1)

Space Complexity:
    * __init__  : O(1)
    * push      : O(1)
    * pop       : O(1)
    * top       : O(1)
    * getMin    : O(1)

Pass on LeetCode: Yes
Problems Occurred: N/A
"""


class MinStack:
    def __init__(self):
        self.stack = []
        self.minimum = float("inf")

    def _setMinimum(self):
        self.minimum = float("inf")
        for i in self.stack:
            if i < self.minimum:
                self.minimum = i

    def push(self, val: int) -> None:
        if val < self.minimum:
            self.minimum = val
        self.stack.append(val)

    def pop(self) -> None:
        item = self.stack.pop()
        if len(self.stack) == 1:
            self.minimum = self.top()
        else:
            self._setMinimum()
        return item

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        if not self.stack:
            return
        if len(self.stack) == 1:
            return self.top()
        else:
            return self.minimum
