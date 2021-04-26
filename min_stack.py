lass MinStack:
    
    def __init__(self):
        self.Firststack = []
        self.Minstack = []
        self.minimum = 10000000000
    

    def push(self, val: int) -> None:
        self.minimum = min(self.minimum,val)
        self.Firststack.append(val)
        self.Minstack.append(self.minimum)
        
    def pop(self) -> None:
        if (self.Firststack):
            self.Firststack.pop()
            self.Minstack.pop()
            if self.Minstack:
                self.minimum = self.Minstack[-1]

    def top(self) -> int:
        return self.Firststack[-1]

    def getMin(self) -> int:
        return self.minimum
        


# Your MinStack object will be instantiated and called as such:
#obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()