# Implement MinStack
'''
Leetcode all test cases passed: Yes
MinStack:
    Space Complexity: O(2n) = O(n)
    push(self, val):
        Time Complexity: O(1)
    pop(self):
        Time Complexity: O(1)
    top(self):    
        Time Complexity: O(1)
    getMin(self):    
        Time Complexity: O(1)
'''


class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.minStack) == 0 or val <= self.minStack[-1]:
            self.minStack.append(val)

    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.minStack[-1]:
            self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        if len(self.minStack) > 0:
            return self.minStack[-1]
        return None
