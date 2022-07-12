# Time Complexity: O(1)? I think because push pop peek in stack are all constant time. Please correct me if I'm wrong
# Space Complexity: O(2n)
# Did code run on Leetcode: Yes
# Approach: I maintain 2 stacks in this case. One the main stack, the other to keep track of the minimum element.
# We need this instead of a variable, because hard to keep track of minimum, incase the minimum element is popped.


from collections import deque
import sys


class MinStack:
    def __init__(self):
        # Initialize the Min Stack
        self.minStack = deque()

        # Taking minimum as Infinity
        self.minimum = sys.maxsize

        # Minimum element tracking Stack
        self.mintrackStack = deque()
        self.mintrackStack.append(self.minimum)

    def push(self, val: int) -> None:
        self.minimum = min(self.minimum, val)
        if self.minimum == val:
            # If current value is the minimum, append to second stack
            self.mintrackStack.append(val)
        self.minStack.append(val)

    def pop(self) -> None:
        self.minimum = self.mintrackStack[-1]
        val = self.minStack.pop()

        if val == self.minimum:
            # If value popped is minimum element, we need to revert minimum value to previous minimum
            self.mintrackStack.pop()
            self.minimum = self.mintrackStack[-1]

    def top(self) -> int:
        return self.minStack[-1]

    def getMin(self) -> int:
        return self.mintrackStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
