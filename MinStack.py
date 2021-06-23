class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []
        self.min_stack.append((2**31) - 1)
        
    def push(self, val: int) -> None:
        if(val < self.min_stack[-1]):
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()  

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


# Time Complexity : O(1)
# Space Complexity : O(n) 