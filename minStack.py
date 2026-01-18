class MinStack:

    def __init__(self):
        self.arr = []
        self.st = []
        self.minValue = float("inf")
        self.st.append(self.minValue)


    def push(self, val: int) -> None:
        self.minValue = min(val, self.minValue)
        self.arr.append(val)

        self.st.append(self.minValue)


    def pop(self) -> None:
        self.arr.pop()
        self.st.pop()
        self.minValue = self.st[-1]


    def top(self) -> int:
        return self.arr[-1]


    def getMin(self) -> int:
        return self.minValue



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()