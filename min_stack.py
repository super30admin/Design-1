"""
Initialized the class with empty stack and min_val with infinity value so that we can compare with incoming value
When we push into the stack if the value is the less than the current minvalue then we push old value to the stack first and then 
push the new value to the stack and update the min-value. Pop will check that current value is the min_value then we do another pop
"""
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_val = float('inf')

    def push(self, val: int) -> None:
        if val <= self.min_val:
            self.stack.append(self.min_val)
            self.min_val = val
        self.stack.append(val)
        

    def pop(self) -> None:
        if not self.stack:
            return
        
        top = self.stack.pop()
        if top == self.min_val:
            self.min_val = self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1] if self.stack else None
        

    def getMin(self) -> int:
        return self.min_val if self.stack else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()