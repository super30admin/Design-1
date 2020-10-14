class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minstack = []
        

    def push(self, x: int) -> None:
        if not self.stack:
            self.stack.append(x)
            self.minstack.append(x)
        else:
            if x < self.minstack[-1]:
                self.minstack.append(x)
            else:
                self.minstack.append(self.minstack[-1])
            self.stack.append(x)
        

    def pop(self) -> None:
            self.minstack.pop()
            self.stack.pop()
        

    def top(self) -> int:
        if not self.stack:
            return None
        else:
            return self.stack[-1]
        

    def getMin(self) -> int:
        if not self.minstack:
            return None
        else:
            return self.minstack[-1]
        

#TC: All the abstract functions will have a TC of O(1)
#SC: Both the stack use asymtotically the space complexity of O(N)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()