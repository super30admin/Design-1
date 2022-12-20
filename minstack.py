class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.min=[float("inf")]
        

    def push(self, x: int) -> None:
        self.stack.append(x)
        if x<=self.min[-1]:
            self.min.append(x)
        

    def pop(self) -> None:
        if self.stack:
            if self.stack[-1]==self.min[-1]:
                self.min.pop(-1)
            self.stack.pop(-1)


    def top(self) -> int:
        k=self.stack[-1]
        return k
        

    def getMin(self) -> int:
        if self.min:
            return self.min[-1]

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()