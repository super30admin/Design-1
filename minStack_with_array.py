import sys

class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = sys.maxsize
        self.minStack.append(sys.maxsize)

    def push(self, val):
        min_val = min(val, self.min)
        self.min =min_val
        self.stack.append(val)
        self.minStack.append(min_val)

    def pop(self):
        self.stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]

    def top(self):
        return self.stack[-1]

    def getMin(self):
        if self.min == sys.maxsize:
            return None
        return self.min