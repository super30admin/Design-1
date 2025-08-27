# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# Returning the whole (value, min_so_far) tuple instead of just the value in top()


# Your code here along with comments explaining your approach
# Keep one stack of tuples `(value, min_so_far)`.
# On `push(val)`, compute `new_min = val if empty else min(val, stack[-1][1])` and push `(val, new_min)`.
# Then `pop()` pops the tuple, `top()` returns tuple[0], and `getMin()` returns tuple[1].


class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if not self.stack:
            # First element: its value is also the min so far.
            self.stack.append((val, val))

        else:
            # Read current minimum from the top tuple's second slot.
            current_min = self.stack[-1][1]
            # Store (value, new_min_so_far) as a tuple.
            # Using conditional equals min(val, prev_min).
            self.stack.append((val, val if val < current_min else current_min))

    def pop(self) -> None:
            # Pop removes the top tuple (value, min_so_far).
        self.stack.pop()

    def top(self) -> int:
        # Return ONLY the value at the top.
        return self.stack[-1][0]

    def getMin(self) -> int:
        # Return the current minimum.
        return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()