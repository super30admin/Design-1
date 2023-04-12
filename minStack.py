## Problem 2:
# Design MinStack (https://leetcode.com/problems/min-stack/)
import sys

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack(object):
    def __init__(self):
        self.stack = []
        self.min = sys.maxsize

    def push(self, x):
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self):
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.min
