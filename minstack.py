"""
TC: O(1)
SC:O(n)
"""

import collections

class MinStack:

    def __init__(self):
        self.mainStack = deque()
        self.minStack = deque()


    def push(self, val: int) -> None:
        self.mainStack.append(val)

        if not self.minStack:
            self.minStack.append(val)
        else:
            if self.minStack[-1] >= val:
                self.minStack.append(val)


    def pop(self) -> None:
        topElement = self.mainStack.pop()
        if topElement == self.minStack[-1]:
            self.minStack.pop()
        return topElement


    def top(self) -> int:
        return self.mainStack[-1]


    def getMin(self) -> int:
        return self.minStack[-1]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
