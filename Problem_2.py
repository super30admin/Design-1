# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class MinStack:
    def __init__(self):
        self.stack = []
        
    def push(self, val: int) -> None:
        return self.stack.append(val)
        
    def pop(self) -> None:
        return self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return min(self.stack)