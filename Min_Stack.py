class MinStack:

    def __init__(self):
        self.data_stack = []
        self.min_stack = []

    def push(self, x) -> None:
        self.data_stack.append(x)
        if len(self.min_stack):
            min_data = self.min_stack[-1]
            self.min_stack.append(x if x < min_data else min_data)
        else:
            self.min_stack.append(x)    

    def pop(self) -> None:
        if len(self.data_stack):
            self.data_stack.pop()
            self.min_stack.pop()

    def top(self) -> int:
        return self.data_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()