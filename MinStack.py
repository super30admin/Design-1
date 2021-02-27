'''
Time Complexity - O(1)
Space Complexity - O(N)
'''
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minimum = float("inf") # For keeping the hold of minimum value

    def push(self, x: int) -> None:
        
        if x<=self.minimum:
            self.stack.append(self.minimum) # We are appending minimum so that when our current minimum is popped, then we have the hold of next minimum
            self.minimum=x
        self.stack.append(x)
        
        

    def pop(self) -> None:
        
        if self.stack.pop()==self.minimum:
            self.minimum=self.stack.pop() # Updating by next minimum

    def top(self) -> int:
        
        if len(self.stack)>0:
            return self.stack[-1]
        
        return -1
        

    def getMin(self) -> int:
        
        return self.minimum # Returning the minimum value
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()