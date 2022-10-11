# Time Complexity is O(1)
# Space Complexity is O(n)
class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if self.stack:
            _min = self.getMin()
            if val < _min:
                _min = val
            self.stack.append((val, _min))
        else:
            self.stack.append((val, val))

    def pop(self) -> None:
        if self.stack:
            last = self.stack[-1][0]
            del(self.stack[-1])
            return last

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]