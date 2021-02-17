class MinStack:

    def __init__(self):
        # Stack
        self.stack = []
        self.min = float('inf') # Infinity

    def push(self, x: int) -> None:
        if x<=self.min:
            self.stack.append(self.min) # Appending previous min value
            self.min = x # Updating min Value
        self.stack.append(x)

    def pop(self) -> None:
        # Pop again if first pop provides min value, update min to previous min
        top = self.stack.pop()
        if top == self.min:
            self.min = self.stack.pop()
            
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min