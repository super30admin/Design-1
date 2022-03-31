# Time Complexity :O(1)
# Space Complexity :O(N) where N is the number of elements
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : Mostly with the python functionality since I have rusted on that
# but I'm taking care of that.

# Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        self.min = float('inf')
        self.stack = []
        self.minimumStack = []
        self.minimumStack.append(self.min)

    def push(self, val: int) -> None:
        if val <= self.min:
            self.min = val
        self.stack.append(val)
        self.minimumStack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minimumStack.pop()
        self.min = self.minimumStack[-1]

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
