# Time Complexity : O(1) for all functions
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
#No

# Your code here along with comments explaining your approach
# Using 2 stacks, one for storing the elements and other for storing the minimum element

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s = []
        self.ms = []

    def push(self, val: int) -> None:
        self.s.append(val)

        if self.ms:
            if self.ms[-1] >= val:
                self.ms.append(val)
        else:
            self.ms.append(val)

    def pop(self) -> None:

        if self.s:
            if self.s[-1] == self.ms[-1]:
                self.s.pop()
                self.ms.pop()
            else:
                self.s.pop()

    def top(self) -> int:
        return self.s[-1]

    def getMin(self) -> int:
        return self.ms[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()