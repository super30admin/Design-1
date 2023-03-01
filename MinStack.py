# Time Complexity: O(1) For each operation
# Space Complexity:O(1) since stack is used for outputting as well
class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append([val, val])
        else:
            min_ele = min(self.stack[-1][1], val)
            self.stack.append([val, min_ele])

    def pop(self) -> None:
        if not self.stack:
            return
        self.stack.pop()

    def top(self) -> int:
        if not self.stack:
            return -1
        return self.stack[-1][0]

    def getMin(self) -> int:
        if not self.stack:
            return None
        return self.stack[-1][1]

m = MinStack()
m.push(-2)
m.push(0)
m.push(-3)
print(m.getMin())
m.pop()
print(m.top())
print(m.getMin())
