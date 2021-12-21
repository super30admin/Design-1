class MinStack:

    def __init__(self):
        self.arr = []
        self.min_val = None

    def push(self, val: int) -> None:
        self.arr.append(val)
        if self.min_val is not None and val < self.min_val:
            self.min_val = val
        if self.min_val is None:
            self.min_val = val

    def pop(self) -> None:
        v = self.arr.pop()
        if v == self.min_val and len(self.arr) != 0:
            self.min_val = min(self.arr)
        if len(self.arr) == 0:
            self.min_val = None

    def top(self) -> int:
        if len(self.arr) != 0:
            return self.arr[-1]
        else:
            return None

    def getMin(self) -> int:
        #return min(self.arr)
        return self.min_val

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()