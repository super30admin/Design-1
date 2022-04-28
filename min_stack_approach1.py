#Time Complexity : O(1) for all operation
 #Space Complexity : O(N)
#Did this code successfully run on Leetcode : Yes it did
#Any problem you faced while coding this :


import sys
class MinStack:
    def __init__(self):
        self.stack = []
        self.minstack = [] #using a new stack to store minimum
        self.mininum = sys.maxsize
        self.minstack.append(self.mininum)
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.mininum = min(self.mininum,val)
        self.minstack.append(self.mininum)
        
    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.mininum = self.minstack[-1]
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.mininum
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
