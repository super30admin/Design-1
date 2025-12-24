"""
// Time Complexity :
    push - o(1)
    pop - o(1)
    top - 0(1)
    get_min - o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, knew I had to use two stacks but had doubts with my approach, had to look at editorial to
confirm my approach was right
"""


class MinStack:

    def __init__(self):
        self.stack = []
        self.mins = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.mins:
            self.mins.append(val)
        elif self.mins[-1] >= val:
            self.mins.append(val)

    def pop(self) -> None:
        element = self.stack.pop()
        if self.mins[-1] == element:
            self.mins.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.mins[-1]
