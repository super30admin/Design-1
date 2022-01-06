class MinStack:

    def __init__(self):
        self.min=float(inf)
        self.arr=[]
        self.arr.append(self.min)
        
    def push(self, val: int) -> None:
        if val<=self.min:
            self.arr.append(self.min)
            self.min=val
        self.arr.append(val)
            

    def pop(self) -> None:
        item=self.arr.pop()
        if item==self.min:
            self.min=self.arr.pop()


    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()