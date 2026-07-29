# Use 2 stacks, one for the actual elements and the other to keep track of current min in the stack
# TC -> O(1)
# SC -> O(n) where n are the number of elemets to store in the stack

class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = [float("inf")]
        
    def push(self, value: int) -> None:
        self.stack.append(value)
        current_min = self.min_stack[-1]
        self.min_stack.append(min(current_min, value))

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()