class MinStack:

    def __init__(self):
        # Using a list to store the elements
        self.stack = []

    def push(self, val: int) -> None:
        # Maintaining tuples as elements of the stack where the first ele is the new element and the second ele is the current min
        currMin = self.getMin()

        # Updating currMin
        if currMin == None or val < currMin:
            currMin = val

        # Appending the tuple
        self.stack.append((val, currMin))

    def pop(self) -> None:
        # Popping the last element of the stack
        self.stack.pop()

    def top(self) -> int:
        if len(self.stack) == 0:
            return None

        # Returning the last tuple's first element
        return self.stack[-1][0]

    def getMin(self) -> int:
        if len(self.stack) == 0:
            return None

        # Returning the last tuple's second element which is the current min
        else:
            return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()