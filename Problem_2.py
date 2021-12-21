# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : I was confused at first but eventually figured it out.

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