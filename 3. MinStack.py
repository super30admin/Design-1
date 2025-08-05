class MinStack:

    def __init__(self):
        # Initialize two stacks:
        # one for all values, another for tracking min values
        self.stack = []
        self.min_stack = []

    def push(self, val: int):
        # Push value to the main stack
        self.stack.append(val)

        # If min_stack is empty or val is less than or equal to current min,
        # push val to min_stack, else push current min again to keep length same
        if not self.min_stack:
            self.min_stack.append(val)
        else:
            current_min = self.min_stack[-1]
            self.min_stack.append(min(val, current_min))

    def pop(self):
        # Pop from both stacks to keep them in sync
        self.stack.pop()
        self.min_stack.pop()

    def top(self):
        # Return the top of the main stack
        return self.stack[-1]

    def getMin(self):
        # Return the top of the min_stack, which is the current min
        return self.min_stack[-1]

# TC: O(1) for all operations
# SC: O(n) for storing elements in the stacks