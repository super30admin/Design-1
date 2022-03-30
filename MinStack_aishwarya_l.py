
"""
Time complexity of MinStack is O(1), and Space complexity is O(n)
and less wastage of memory
"""
class MinStack:

    def __init__(self):
        self.min_val = float('inf')
        self.main_stack = []
        self.min_stack = []
        self.min_stack.append(self.min_val)

    def push(self, val: int) -> None:
        if val < self.min_val:
            self.min_val = val
        self.min_stack.append(self.min_val)
        self.main_stack.append(val)

    def pop(self) -> None:
        self.main_stack.pop()
        self.min_stack.pop()
        self.min_val = self.min_stack[-1]

    def top(self) -> int:
        return self.main_stack[-1]

    def getMin(self) -> int:
        return self.min_val


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
