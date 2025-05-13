# Author : Akaash Trivedi
# Time Complexity : O(1)
# Space Complexity : O(n) N is the number of element in the stack
# Did this code successfully run on Leetcode : Yes #155
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val,val))
            return
        currentMin = self.stack[-1][1]
        self.stack.append((val,min(val,currentMin)))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()