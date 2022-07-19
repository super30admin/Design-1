# Implement Queue using Stack
'''
Leetcode all test cases passed: Yes
MyQueue:
    Space Complexity: Number elements in stack n = O(n)
    push(self, x):
        Time Complexity: O(1)
    pop(self, x):
        Time Complexity:
            Average Case: O(1)
            Worst Case: O(n)
    peek(self, x):
        Time Complexity:
            Average Case: O(1)
            Worst Case: O(n)
    empty(self, x):
        Time Complexity: O(1)
'''


class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack) > 0:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        if len(self.inStack) == 0 and len(self.outStack) == 0:
            return True
        return False
