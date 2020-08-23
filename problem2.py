# Design MinStack 

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack1 = []
        self.min = float('inf')
        

    def push(self, x: int) -> None:
        if x<=self.min:
            self.stack1.append(self.min)
            self.min = x
        self.stack1.append(x)
        

    def pop(self) -> None:
        x = self.stack1.pop()
        if x==self.min:
            self.min = self.stack1.pop()
        

    def top(self) -> int:
        return self.stack1[-1]

    def getMin(self) -> int:
        return self.min
        
# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

