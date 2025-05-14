# Maintaining two stack such that the 1st stack contains all the elements
# the second stack will be updated with elements either if it is empty
# or when the new value is smaller than the current minimum element

class MinStack:
    def __init__(self):
        self.stack=[] 
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])


    def pop(self) -> None:
        del self.stack[-1]
        del self.min_stack[-1]


    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()