# Time Complexity : O(1)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 

class MinStack:

    def __init__(self):
        self.stack = []
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        

    def pop(self) -> None:
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return min(self.stack)
            
        