class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.item=[]

    def push(self, x: int) -> None:
        self.item.append(x)

    def pop(self) -> None:
        self.item.pop(-1)

    def top(self) -> int:
        return self.item[-1]


    def getMin(self) -> int:
        if self.item:
            return min(self.item)



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
