class MinStack:

    def __init__(self):
        self.stack_1 = []
        self.stack_2 = []
        

    def push(self, val: int) -> None:
            self.stack_1.append(val)
            if not self.stack_2 or val<= self.stack_2[-1]:
                self.stack_2.append(val)

    def pop(self) -> None:
        tem = self.stack_1.pop()
        if ( tem == self.stack_2[-1]):
            self.stack_2.pop()

    def top(self) -> int:
         return self.stack_1[-1]

    def getMin(self) -> int:
        return self.stack_2[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()