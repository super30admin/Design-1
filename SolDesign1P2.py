"""
LC 155: Min stack
-Time Complexity : for all operations O(1)
-Space Complexity : O(N) where N is the number of elements
-Did this code successfully run on Leetcode : Yes
-Any problem you faced while coding this : No
-Your code here along with comments explaining your approach

Used 2 stacks- 1st to store the elements and 2nd to store the minimum value so far. 
If pop, check if elem == top of min stack, if yes then pop the min stack also.
If not, then just pop the element stack
"""

class MinStack:

    def __init__(self):
        self.minSoFarStack = []
        self.elemStack = []

    def push(self, val: int) -> None:
        if len(self.minSoFarStack) == 0 or (len(self.minSoFarStack) > 0 and val <= self.minSoFarStack[-1]):
            self.minSoFarStack.append(val)
        self.elemStack.append(val)

    def pop(self) -> None:
        if self.elemStack[-1] == self.minSoFarStack[-1]:
            self.minSoFarStack.pop()
        self.elemStack.pop()

    def top(self) -> int:
        return self.elemStack[-1]

    def getMin(self) -> int:
        return self.minSoFarStack[-1]