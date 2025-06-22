# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque


class MinStack:
    # Implementing min stack using single stack and pushing previous min to stack when new min is found.
    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val: int) -> None:       

        if val<=self.min:
            # if val is smaller than min, then push prev min to top of stack and assign min to new val 
            self.stack.append(self.min)

            self.min = val
        # push new val to top of stack
        self.stack.append(val)

    def pop(self) -> None:
        if not self.stack:
            return
        # if popped item is equal to min, then pop again and assign to min as it contains prev min
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        if not self.stack:
            return None
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
