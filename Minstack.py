'''
This MinStack class implements a stack data structure that, in addition to usual push and pop operations, has a function to retrieve the minimum element in O(1) time. The stack is implemented using a Python list, and a variable 'min' keeps track of the current minimum. Upon every push operation, if the new element is smaller or equal to the current minimum, it first pushes the current minimum onto the stack and then the new element.
'''

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:
        if self.stack:
            popped = self.stack.pop()
            if popped == self.min:
                self.min = self.stack.pop() if self.stack else float('inf')

    def top(self) -> int:
        return self.stack[-1] if self.stack else None

    def getMin(self) -> int:
        return self.min if self.min != float('inf') else None
