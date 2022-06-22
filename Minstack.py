
# Time Complexity : O(1) 
# Space Complexity : O(n) max n values extra
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None 
# Your code here along with comments explaining your approach

import sys
class MinStack:

    # Initialize the min value to be max int value
    def __init__(self):
        self.stack = []
        self.min = sys.maxsize

    # Push value to stack check if the value is less
    #  than min value if yes then push that value twice
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    # If the popped value is min value, 
    # min becomes the next popped value
    def pop(self) -> None:
        if self.min == self.stack.pop():
            self.min = self.stack.pop()
    # Can get this simply
    def top(self) -> int:
        return self.stack[-1]
        
    # This is maintained hence we directly get this
    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()