# Time Complexity : O(1) 
# Space Complexity : O(2n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import sys
class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.min = sys.maxsize
        self.minSt.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(self.min, val)
        self.st.append(val)
        self.minSt.append(self.min)
        

    def pop(self) -> None:
       self.st.pop()
       self.minSt.pop()
       self.min = self.minSt[-1]

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()