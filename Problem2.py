"""
I created two lists: one for the regular stack and another for tracking minimum values. In the push function, elements are added to both stacks if needed to maintain the minimum. In pop, if the top element of the min stack matches the popped element, it's removed from both stacks.
"""
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)

    def pop(self) -> None:
        if self.stack:
            popElement = self.stack.pop()
            if popElement == self.minStack[-1]:
                self.minStack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        else:
            return None

    def getMin(self) -> int:
        if self.minStack:
            return self.minStack[-1]
        else:
            return None
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()