# Time Complexity : O(1)
# Space Complexity : O(2n) ~ O(n)

class MinStack:

    def __init__(self):
        self.list1 = []
        self.min = 0

    def push(self, val: int) -> None:
        if self.list1 == []:
            self.min = val
        elif val < self.list1[len(self.list1)-1][1]:
            self.min = val
        else:
            self.min = self.list1[len(self.list1)-1][1]
        self.list1.append([val, self.min])

    def pop(self) -> None:
        self.list1.pop()

    def top(self) -> int:
        return self.list1[len(self.list1)-1][0]

    def getMin(self) -> int:
        return self.list1[len(self.list1)-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()