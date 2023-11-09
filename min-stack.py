# Time and Space Complexity is O(1)

class MinStack:

    def __init__(self):
        self.stack = []                                   # Initializing empty main stack
        self.minStack = []                                # Initializing empty min stack
        

    def push(self, val: int) -> None:
        self.stack.append(val)                            # Push operation to main stack
        if self.minStack:                                 # Checking if minStack is not empty
            val = min(val, self.minStack[-1])             # Compare the arg value with the top of minStack, if top of minStack value is smaller, the same is appended again to minStack, else the arg value (new minimum) is appended.
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()