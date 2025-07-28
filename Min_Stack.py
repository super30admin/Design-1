class MinStack:
    # Time Complexity: push, pop, top, getMin → O(1) each
    # Space Complexity: O(n) — storing all elements and their corresponding minimums
    # Leetcode: yes
    # Faced issues: No, concept clear after class

    def __init__(self):
        # Main stack to store [value, current min] pairs
        self.stack = []
        # Initialize minimum value to positive infinity
        self.minimum = float('inf')

    def push(self, val: int) -> None:
        # Update minimum if new value is smaller
        self.minimum = min(val, self.minimum)
        # Push both value and current min into stack
        self.stack.append([val, self.minimum])

    def pop(self) -> None:
        # Pop the top element
        self.stack.pop()
        # Reset minimum to the new top's min if stack isn't empty, otherwise, set it back to infinity
        self.minimum = self.stack[-1][1] if self.stack else float('inf')

    def top(self) -> int:
        # Return the top value (not the min)
        if not self.stack:
            return None  # Stack is empty
        return self.stack[-1][0]

    def getMin(self) -> int:
        # Return current minimum from top of stack
        if not self.stack:
            return None  # Stack is empty
        return self.stack[-1][1]
