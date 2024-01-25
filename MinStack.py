# Time Complexity : o(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Not in this problem


class MinStack:

    def __init__(self):
        """ Initialized two stacks one is for storing the elements 
        and other for storing min value """
        self.stck = []
        self.minStck = []

    def push(self, val: int) -> None:
        # Appending to main stack and if value is minimum then appending to min stack
        self.stck.append(val)
        if not self.minStck or val <= self.minStck[-1]:
            self.minStck.append(val)

    def pop(self) -> None:
        # Poping from main stack and if value is minimum then poping from min stack aswell
        ele = self.stck.pop(-1)
        if ele == self.minStck[-1]:
            self.minStck.pop(-1)

    def top(self) -> int:
        # Just return last element of main stack
        return self.stck[-1]

    def getMin(self) -> int:
        # Returning last element of min stack
        return self.minStck[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
