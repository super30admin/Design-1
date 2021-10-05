# Time Complexity: Insertion O(1) Search O(1)
# Space Complexity: O(n)
# Ran Successfully on Leetcode -71 ms

class MinStack:

    def __init__(self):
        self.stack = []
        self.minVal = []

    def push(self, val: int) -> None:
        if len(self.minVal) == 0 or val <= self.minVal[-1]:
            self.minVal.append(val)
        self.stack.append(val)

    def pop(self) -> None:
        if self.stack[-1] == self.minVal[-1]:
            self.minVal.pop()
        self.stack.pop()

    def top(self) -> int:
        val = self.stack[-1]
        return val

    def getMin(self) -> int:
        val = self.minVal[-1]
        return val
