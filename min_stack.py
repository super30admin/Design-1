"""
All operations have a time complexity of O(1)
The space complexity is O(n)
"""


class MinStack:
    def __init__(self):
        self.stack = []
        self.stack_desc = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.stack_desc or val <= self.stack_desc[-1]:
            self.stack_desc.append(val)

    def pop(self) -> None:
        if self.stack.pop() == self.stack_desc[-1]:
            self.stack_desc.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.stack_desc[-1]
