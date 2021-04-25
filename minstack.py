class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minstack = []
        self.min = 0
        

    def push(self, val: int) -> None:
        if not self.minstack:
            self.min = val

        else:
            if val < self.min:
                self.min = val
        self.minstack.append((val,self.min))
        

    def pop(self) -> None:
        del self.minstack[-1]
        if self.minstack:
            self.min = self.minstack[-1][1]
        

    def top(self) -> int:
        return self.minstack[-1][0]
        

    def getMin(self) -> int:
        return self.minstack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()