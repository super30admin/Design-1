from collections import deque
class MinStack:

    def __init__(self):
        self.mins = deque()
        self.stack = deque()

    def push(self, val: int) -> None:
        if len(self.mins) == 0:
            currentMin = val
        else:
            currentMin = self.mins[0]
        
        self.stack.appendleft(val)
        if val < currentMin:
            currentMin = val
        self.mins.appendleft(currentMin)

    def pop(self) -> None:
        if len(self.stack) == 0:
            return
        self.stack.popleft()
        self.mins.popleft()

    def top(self) -> int:
        return self.stack[0]
        

    def getMin(self) -> int:
        return self.mins[0]
