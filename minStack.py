// Time Complexity : push O(1), pop O(1), top O(1), getMin O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = float('inf')
        self.minStack.append(self.min)
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if val <= self.min :
            self.min = val
            self.minStack.append(self.min)

    def pop(self) -> None:
        element = self.stack.pop()
        if element == self.min :
            self.minStack.pop()
            self.min = self.minStack[-1]

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
