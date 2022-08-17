class MinStack:
    def __init__(self):
        self.list = []
        self.min_value = float('inf')
        self.min_list = [self.min_value]
        
    def push(self, val: int) -> None:
        self.list.append(val)
        if val < self.getMin():
            self.min_list.append(val)
            self.min_value = val
        else:
            self.min_list.append(self.min_value)

    def pop(self) -> None:
        self.list.pop()
        self.min_list.pop()
        self.min_value = self.getMin()
        
    def top(self) -> int:
        return self.list[-1]
        
    def getMin(self) -> int:
        return self.min_list[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
