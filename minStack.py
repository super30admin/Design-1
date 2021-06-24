# Single stack approach

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = sys.maxsize
        
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        
    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.min:
            self.min = self.stack.pop()
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min
    
# Time Complexity: O(1)
#Space Complexity: O(N)
