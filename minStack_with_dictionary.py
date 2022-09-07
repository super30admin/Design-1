# Time Complexity : O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Stumbled with the logic while implementing the dictionary,
# and ensuring to update the dictionary while popping and pushing

import sys


class MinStack:

    def __init__(self):
        self.stack = []
        self.min = sys.maxsize
        self.minLookup = {}

    def push(self, val: int) -> None:
        if val < self.min:
            self.min = val
        self.stack.append(val)
        self.minLookup[len(self.stack)] = self.min

    def pop(self) -> None:
        if len(self.stack) == 1:
            self.min = sys.maxsize
        if self.minLookup:
            del self.minLookup[len(self.stack)]
        if self.top() == self.min:
            self.min = self.minLookup[len(self.stack) - 1]
        return self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minLookup[len(self.stack)]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
