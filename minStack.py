# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.mainStack = []
        self.minStack = []

    def push(self, val: int) -> None:
        if len(self.mainStack) == 0 or val <= self.minStack[-1]:
            self.minStack.append(val)
        self.mainStack.append(val)

    def pop(self) -> None:
        if len(self.mainStack) != 0:
            if self.minStack[-1] == self.mainStack[-1]:
                self.minStack.pop()
            self.mainStack.pop()

    def top(self) -> int:
        return self.mainStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]