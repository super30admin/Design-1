# Time complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# I used two stacks to solve this problem.
# One to maintain the values and the other to maintain the minimums. Every push or pop operation was synced

import math
import sys


class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.minimum = sys.maxsize
        self.minSt.append(self.minimum)

    def push(self, val: int) -> None:
        self.minimum = min(val, self.minimum)
        self.st.append(val)
        self.minSt.append(self.minimum)

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.minimum = self.minSt[-1]

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.minimum


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
