class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        # Push to minStack if empty or new val <= current min
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)

    def pop(self) -> None:
        popped = self.stack.pop()
        # Pop from minStack if popped element is the current min
        if popped == self.minStack[-1]:
            self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]

# Time Complexity :
# - push: O(1)
# - pop: O(1)
# - top: O(1)
# - getMin: O(1)

# Space Complexity :
# - O(n) for both stacks in worst case (all elements pushed are decreasing, so minStack grows same as stack)

# Did this code successfully run on Leetcode : Yes

# approach###
# Use two stacks to maintain constant time retrieval of minimum element.
# The main stack stores all values.
# The minStack keeps track of the minimum element at each insertion point.
# When pushing, if new element is <= current min, push it onto minStack.
# When popping, if popped element matches minStack top, pop minStack as well.
# This ensures getMin always returns current minimum in O(1) time.

