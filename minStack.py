# https://leetcode.com/problems/min-stack
# Time Complexity : O(1) for all of the functions
# Space Complexity : O(n) for stack and O(n) for minStack if every new element pushed is smaller than previous
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach


class MinStack:

    def __init__(self):
        self.l = list()
        self.min = list()

    def push(self, val: int) -> None:
        self.l.append(val)
        if not self.min or val <= self.min[-1]:
            self.min.append(val)

    def pop(self) -> None:

        if self.min[-1] == self.l[-1]:
            self.min.pop()

        self.l.pop()

    def top(self) -> int:
        return self.l[-1]

    def getMin(self) -> int:
        return self.min[-1] if self.min else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()