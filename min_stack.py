# Time Complexity : Min Stack: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : it runs in IDE, but fails in leetcode
# Any problem you faced while coding this : No


import sys


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_val = sys.maxsize
        self.size = 100

    def push(self, x: int) -> None:
        if len(self.stack) > self.size:
            print("Stack is full")
            return None

        else:
            if x <= self.min_val:
                self.stack.append(self.min_val)
                self.min_val = x

            self.stack.append(x)

    def pop(self) -> None:
        if len(self.stack) < 1:
            print("stack is empty")
            return -1
        else:
            val = self.stack.pop()
            if val == self.min_val:
                # we pop again
                self.min_val = self.stack.pop()

    def top(self) -> int:
        if len(self.stack) < 1:
            print("stack is empty")
            return -1
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min_val

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
param_3 = obj.top()
#obj.pop()
obj.push(5)
param_3 = obj.top()
param_4 = obj.getMin()

print(param_3, param_4)