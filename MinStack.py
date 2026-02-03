'''
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
class MinStack:

    def __init__(self):
        self.stack = []
        
    def isEmpty(self):
        return len(self.stack) == 0

    def push(self, val: int) -> None:
        self.stack.append(val)

    def pop(self) -> None:
        if not self.isEmpty():
            return self.stack.pop()
        
    def top(self) -> int:
        if not self.isEmpty():
            return self.stack[-1]

    def getMin(self) -> int:
        return min(self.stack)