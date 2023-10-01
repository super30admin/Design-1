# time complexity for all : O(1)
# space complexity for all: O(1)

class MinStack:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        self.min_val = float('inf') 
        self.stack2.append(self.min_val)

    def push(self, val: int) -> None:
        self.min_val = min(val, self.min_val)
        self.stack1.append(val)
        self.stack2.append(self.min_val)

    def pop(self) -> None:
        self.stack1.pop()
        self.stack2.pop()
        self.min_val = self.stack2[-1]

    def top(self) -> int:
        return self.stack1[-1]

    def getMin(self) -> int:
        return self.min_val
