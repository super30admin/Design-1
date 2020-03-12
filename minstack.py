class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minSt = []

    def push(self, x: int) -> None:
        
        newMin = x if not self.minSt else min( x, self.minSt[-1] )

        self.stack.append( x )
        self.minSt.append( newMin )
        
    def pop(self) -> None:
        
        self.stack.pop()
        self.minSt.pop()
        

    def top(self) -> int:
        
        return self.stack[-1]

    def getMin(self) -> int:
        
        return self.minSt[-1]

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()