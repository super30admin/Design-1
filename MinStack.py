# Time Complexity : O(1) for retrieving the minimum value
# Space Complexity : O(n) for the two stacks
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []
        self.minimumStack = []

    def push(self, x: int) -> None:
        self.arr.append(x)
        if not self.minimumStack or x <= self.minimumStack[-1]:
            self.minimumStack.append(x)

    def pop(self) -> None:
        poppedValue = self.arr.pop()

        if poppedValue == self.minimumStack[-1]:
            self.minimumStack.pop()

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return self.minimumStack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()