# Leetcode username : shreyagoyal06
# Taking one stack for storing values and other for storing minimum value, while pushing the value, it is first added to stack and then to min stack if the min stack is empty or the current value is less than or equal to the current min
# While popping, we pop from stack and if the value was minimum then we pop from min stack too as it is no more existing in our stack
# Top value is returned from the top of the stack and minimum is returned from the top of the min stack


class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []
    
    def push(self, val: int) -> None:
        self.stack.append(val)
        # Only pushing to min_stack if it's empty or the current value is <= current min
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
    
    def pop(self) -> None:
        val = self.stack.pop()
        # Only popping from min_stack if the popped value was the minimum
        if val == self.min_stack[-1]:
            self.min_stack.pop()
    
    def top(self) -> int:
        return self.stack[-1]
    
    def getMin(self) -> int:
        return self.min_stack[-1]
