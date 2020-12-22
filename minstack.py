class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        

    def push(self, x: int) -> None:
        if(len(self.stack)==0):
            self.stack.append((x, x))
            return
        num = self.top()
        min1 = self.getMin()
        if(x<min1):
            self.stack.append((x, x))
        else:
            self.stack.append((x, min1))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        if(len(self.stack)>0):
            return self.stack[-1][0]
        else:
            return -1

    def getMin(self) -> int:
        if(len(self.stack)>0):
            return self.stack[-1][1]
        else:
            return -1


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()