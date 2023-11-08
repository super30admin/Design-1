
#Time Complexity: O(1) for each operation -> push, pop, top, getMin
# Space Complexity: O(N), where N is the number of elements stored in the stack
class MinStack:

    def __init__(self):
        # Initializing  the stack as a list of tuples (value, current minimum)
        self.stack = []

    def push(self, val: int) -> None:
        # Calculating  the current minimum between the new value and the previous minimum
        min_val = min(val, self.stack[-1][1] if self.stack else val)
        # Pushing the value and current minimum as a tuple onto the stack
        self.stack.append((val, min_val))

    def pop(self) -> None:
        # Popping  the top element from the stack
        self.stack.pop()

    def top(self) -> int:
        # Returning the value of the top element
        return self.stack[-1][0]

    def getMin(self) -> int:
        # Return the current minimum stored in the top element of the stack
        return self.stack[-1][1]
