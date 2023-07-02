// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No


class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = 2**31 - 1
        self.minStack.append(2**31 - 1)

    def push(self, val: int) -> None:
        self.min = min(self.min, val)
        self.stack.append(val)
        self.minStack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]
        
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        else:
            return null

    def getMin(self) -> int:
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
// Your code here along with comments explaining your approach
