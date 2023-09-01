#Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach


import sys

class MinStack:

    def __init__(self):
        self.stack=[]
        self.min1=sys.maxsize
        

    def push(self, val: int) -> None:
        if(self.min1 >= val ):
            self.stack.append(self.min1)
            self.min1=val
        self.stack.append(val)

    def pop(self) -> None:
        popped_val=self.stack.pop()
        if(popped_val == self.min1 ):
            self.min1=self.stack.pop()
            

    def top(self) -> int:
        return int(self.stack[-1])

    def getMin(self) -> int:
        return self.min1


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
