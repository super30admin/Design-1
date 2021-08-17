class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.L = []
        self.min_Element = []

    def push(self, val: int) -> None:
        self.L.append(val)
        if len(self.min_Element) == 0:
            self.min_Element.append(val)
        else:
            self.min_Element.append(min(val, self.min_Element[-1]))

    def pop(self) -> None:
        self.L.pop()
        self.min_Element.pop()

    def top(self) -> int:
        return self.L[-1]

    def getMin(self) -> int:
        return self.min_Element[-1]


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.L)
obj.pop()
print(obj.L)
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)
