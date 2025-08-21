class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        if self.stack:
            get_min = self.stack[-1][1]
            if val < get_min: 
                new_node = (val, val)
            else: 
                new_node = (val, get_min)
        else:
            new_node = (val, val)
        self.stack.append(new_node)

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
