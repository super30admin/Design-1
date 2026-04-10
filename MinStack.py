# Time Complexity : O(1) for all operations
# Space Complexity : O(n) for all operations
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
## Using 2 lists with one storing the actual numbers and the 2nd storing the minimum value at every instance


class MinStack:

    def __init__(self):
        self.Stack = []
        self.minStack = []
        self.min = float('inf')
        self.minStack.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(val, self.min)
        self.Stack.append(val)
        self.minStack.append(self.min)

    def pop(self) -> None:
        self.Stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]

    def top(self) -> int:
        return self.Stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()