# Time Complexity O(1) for all operation except the finding minimum
# Space Complexity O(n) overall

class MinStack:

    def __init__(self):
        self.min = []
        self.stack = []

    def push(self, val: int) -> None:
        if len(self.stack) == 0:
            self.stack.append(val)
            self.min.append(val)
        else:
            self.stack.append(val)
            if self.min[-1] > val:
                self.min.append(val)
            else:
                self.min.append(self.min[-1])
                

    def pop(self) -> None:
        #print(self.stack)
        self.min.pop()
        return self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        #print(self.stack)
        return self.min[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
