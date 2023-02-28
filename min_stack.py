class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        # Add val to stack
        self.stack.append(val)
        
        # Push "val" if it is the minimum seen so far, along with its frequency
        if not self.min_stack or val <= self.min_stack[-1][0]:
            self.min_stack.append([val,1])
        # Add the frequency of times the minimum value has been seen so far
        elif val == self.min_stack[-1][0]:
            self.min_stack[-1][1] += 1

    def pop(self) -> None:
        # If popping the minimum value, decrement the frequency by 1
        # and remove it completely is the frequency becomes 0
        if self.min_stack[-1][0] == self.stack[-1]:
            self.min_stack[-1][1] -= 1
        
        if self.min_stack[-1][1] == 0:
            self.min_stack.pop()
        
        # Remove from stack
        self.stack.pop()

    def top(self) -> int:
        # Top of stack
        return self.stack[-1]

    def getMin(self) -> int:
        # Top of min stack
        return self.min_stack[-1][0]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()