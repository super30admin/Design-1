# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.minItem = float('inf')
        self.originalStack = []
        self.minStack = []

    def push(self, val: int) -> None:
        if val <= self.minItem:
            self.minItem = val
        self.originalStack.append(val)
        self.minStack.append(self.minItem)

    def pop(self) -> None:
        self.originalStack.pop()
        self.minStack.pop()
        if self.minItem != self.minStack[-1]:
            self.minItem = self.minStack[-1]

    def top(self) -> int:
        return self.originalStack[-1]

    def getMin(self) -> int:
        return self.minItem


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()