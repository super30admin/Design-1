# Time complexity: O(1)
# Space complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

'''
Implementation idea: create a stack that stores a tuple(value,minValSoFar). With this, we will have access to the minimum value at any point 
'''


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, val: int) -> None:
        if self.stack:
            minVal = min(self.stack[-1][1], val)
            self.stack.append((val, minVal))
        else:
            self.stack.append((val, val))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1][0]

    def getMin(self) -> int:
        if self.stack:
            return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
