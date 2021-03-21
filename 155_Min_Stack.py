class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float('inf')

    ### O(1)
    def push(self, x: int) -> None:
        if (x <= self.min):
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    ### O(1)
    def pop(self) -> None:
        popped_element = self.stack.pop()
        if popped_element == self.min:
            self.min = self.stack.pop()
        return popped_element

    ### O(1)        
    def top(self) -> int:
        return self.stack[-1]

    ### O(1)
    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()