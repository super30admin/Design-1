'''
Problem 2:

Design MinStack (https://leetcode.com/problems/min-stack/)
'''

import sys


class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.Min = int(sys.maxsize)
        self.minSt.append(self.Min)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min = val
        self.st.append(val)
        self.minSt.append(self.Min)    

    def pop(self) -> None:
        self.st.pop()
        self.minSt.pop()
        self.Min = self.minSt[-1]

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.Min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()