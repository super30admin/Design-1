# Time Complexity - O(1) for all operations

# Space Complexity - O(n) where n is the length of the minstack

# The code successfully ran on Leetcode

#Code
# I used the list data structure to implement my MinStack. Python provides many functions default functions
# for list which I have used to solve the problem.
class MinStack:

    def __init__(self):
        self.minstack = []
        """
        initialize your data structure here.
        """

    def push(self, x: int) -> None:
        self.minstack.append(x)

    def pop(self) -> None:
        self.minstack.pop()

    def top(self) -> int:
        return self.minstack[-1]

    def getMin(self) -> int:
        return min(self.minstack)

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()