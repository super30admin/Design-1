class MinStack:
    arr = []
    arrMin = []
    i = 0
    j = 0
    def __init__(self):
        self.i, self.j = 0, 0
    def push(self, val: int) -> None:
        self.arr.append(val)
        if self.j == 0:
            self.arrMin.append(val)
        else:
            if self.arrMin[self.j - 1] > val:
                self.arrMin.append(val)
            else:
                self.arrMin.append(self.arrMin[self.j - 1])

        self.i += 1
        self.j += 1
        
    def pop(self) -> None:
        print(self.arrMin[len(self.arrMin) - 1])
        self.arrMin = self.arrMin[0:len(self.arrMin) - 1]
        self.arr = self.arr[0:len(self.arr) - 1]
        self.i -= 1
        self.j -= 1
        

    def top(self) -> int:
        return self.arr[len(self.arr) - 1]

    def getMin(self) -> int:
        return self.arrMin[len(self.arrMin) - 1]


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(10)
obj.push(20)
obj.pop()
obj.push(30)
param_3 = obj.top()
param_4 = obj.getMin()
print(param_3, param_4)