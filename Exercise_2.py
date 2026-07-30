# Min Stack
# https://leetcode.com/problems/min-stack/description/

# Time complexity: O(1)
# Space complexity: O(n)

# Uses an additional stack to maintain the current minimum value. Push to min_stack when change in min value or equal. Similarly, pop when min value is popped.

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, value: int) -> None:
        self.stack.append(value)
        if not self.min_stack or value <= self.min_stack[-1]:
            self.min_stack.append(value)

    def pop(self) -> None:
        if self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
        self.stack.pop() 

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
