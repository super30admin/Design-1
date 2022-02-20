# Time Complexity: O(1)     during all push, pop, getmin
# Space Complexity: O(n), worst case O(2n)
# Did this code successfully run on Leetcode: Yes

import sys


class MinStack:

    def __init__(self):
        self.min = sys.maxsize
        self.stack = []

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.stack.append(val)
            self.min = val
        else:
            self.stack.append(val)

    def pop(self) -> None:
        if self.stack[-1] == self.min:
            temp = self.stack.pop()
            self.min = self.stack.pop()
            return temp
        else:
            self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


minStack = MinStack()
minStack.push(0)
minStack.push(1)
minStack.push(0)
minStack.getMin()
minStack.pop()
minStack.getMin()
minStack.top()
minStack.getMin()