class MinStack:
    
    def __init__(self):
        self.minst= []
        self.min= float('inf')    

    def push(self, val: int) -> None:
        if(val<=self.min):
            self.minst.append(self.min)
            self.min = val
        self.minst.append(val)
    def pop(self) -> None:
        if(self.minst.pop()==self.min):
            self.min = self.minst.pop()

    def top(self) -> int:
        return self.minst[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()