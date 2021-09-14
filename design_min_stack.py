class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr = []
        self.min = float("inf")

    def push(self, val: int) -> None:
        # if val < self.min:
        #     self.min = val
        self.arr.append(val)

    def pop(self) -> None:
        last_element = self.arr[-1]
        del self.arr[-1]
        return last_element

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return min(self.arr)


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
