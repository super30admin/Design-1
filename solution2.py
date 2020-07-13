# // Time Complexity : o(1)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
#
#
# // Your code here along with comments explaining your approach
# Problem 2:
# Design MinStack (https://leetcode.com/problems/min-stack/)

import sys


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s1 = []
        self.min = sys.maxsize

    def push(self, x: int) -> None:
        if x <= self.min:
            self.s1.append(self.min)
            self.min = x
        self.s1.append(x)

    def pop(self) -> None:
        val = self.s1.pop()
        if val == self.min:
            self.min = self.s1.pop()

    def top(self) -> int:
        return self.s1[-1]

    def getMin(self) -> int:
        return self.min

    # Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()