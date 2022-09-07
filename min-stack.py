# Time Complexity: O(1)
# Space Complexity: O(n)

# Code tested and submitted on Leetcode

class MinStack:

    def __init__(self):
        self.stack = []
        self.minimum = sys.maxsize

        
    def push(self, val: int) -> None:
        if val <= self.minimum:
            self.stack.append(self.minimum)
            self.stack.append(val)
            self.minimum = val
            return
        
        self.stack.append(val)
        
        
    def pop(self) -> None:
        if self.stack[-1] == self.minimum:
            self.stack.pop()
            self.minimum = self.stack[-1]
            self.stack.pop()
            return
        
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]

    
    def getMin(self) -> int:
        return self.minimum
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()