#Time Complexity : O(1) for all operation
 #Space Complexity : O(N)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :


import sys
class MinStack:
    def __init__(self):
        self.stack = []
        self.minimum = sys.maxsize
        
    #pushed previous minimum below current minimum
    def push(self, val: int) -> None:
        if self.minimum >= val:
            self.stack.append(self.minimum)
            self.minimum = min(self.minimum,val)
        self.stack.append(val)
        
    #minimum = element poped from stack.reset minimum to previous minimum
    def pop(self) -> None:
        if self.minimum == self.stack.pop():
            self.minimum = self.stack.pop()
        
        

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
