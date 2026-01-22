# two stacks: one for all values and one for tracking the minimum at each level.
# Every time we push a value, we also push the new minimum so far onto the min stack.
# This ensures that getMin(), top(), and pop() all run in O(1) time with no extra computation.

class MinStack:

    def __init__(self):
        self.stack = []      # main stack
        self.min_stack = []  # stack of minimums

    def push(self, val: int) -> None:
        self.stack.append(val)
        # If min_stack is empty or val is smaller/equal, push it as the new minimum
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            # Repeat the current minimum to keep stacks aligned
            self.min_stack.append(self.min_stack[-1])

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
