# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_tracker = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.min_tracker) == 0 or val <= self.min_tracker[-1]:
            self.min_tracker.append(val)

    def pop(self) -> None:
        
        if (self.min_tracker) and self.stack[-1] == self.min_tracker[-1]:
            self.min_tracker.pop()
        if self.stack:
            self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]

    def getMin(self) -> int:
        if (self.min_tracker):
            return self.min_tracker[-1]


