class MinStack:

    def __init__(self):
    # O(1) Time Complexity;O(n) Space Complexity
        self.stack = []
        self.store_min_stack = []
        
        

    def push(self, val: int) -> None:
    # O(1) Time Complexity;O(1) Space Complexity
        self.stack.append(val)
        if self.store_min_stack:
            val = min(val, self.store_min_stack[-1])
        else:
            val = val
        self.store_min_stack.append(val)
        

    def pop(self) -> None:
    # O(1) Time Complexity;O(1) Space Complexity
        self.stack.pop()
        self.store_min_stack.pop()
        

    def top(self) -> int:
    # O(1) Time Complexity;O(1) Space Complexity
        return self.stack[-1]
        

    def getMin(self) -> int:
    # O(1) Time Complexity;O(1) Space Complexity
        return self.store_min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
