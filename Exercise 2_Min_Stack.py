# Time Complexity : O(1)
# Space Complexity : O(2n) --> O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_value = float('inf')

    def push(self, val: int) -> None:
        
        if val <= self.min_value:
            self.stack.append(self.min_value)
            self.min_value = val

        self.stack.append(val)

    def pop(self) -> None:
        
        val = self.stack.pop(-1)
        if self.min_value == val:
            self.min_value = self.stack.pop(-1)

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_value



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()