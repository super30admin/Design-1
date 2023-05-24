class MinStack:

    def __init__(self):
       self.items = []
       self.min_val=[]

    def push(self, val: int) -> None:
        self.items.append(val)
        if not self.min_val or val <= self.min_val[-1]:
            self.min_val.append(val)


    def pop(self) -> None:
        if self.items[-1] == self.min_val[-1]:
            self.min_val.pop()
        return self.items.pop()

    def top(self) -> int:
        return self.items[-1]

    def getMin(self) -> int:
        return  self.min_val[-1]

# Your MinStack object will be instantiated and called as such:
#obj = MinStack()
#obj.push(1)
#obj.pop()
#param_3 = obj.top()
#param_4 = obj.getMin()