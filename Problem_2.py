# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I was confused at first but figured out eventually
# still have to change it to the right one 
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
