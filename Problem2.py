import math
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = list()
        self.minimum = math.inf


    def push(self, val: int) -> None:
        if val<=self.minimum:
            self.stack.append(self.minimum)
            self.stack.append(val)
            self.minimum = val
        else:
            self.stack.append(val)



    def pop(self) -> None:
        topval = self.stack.pop()
        if topval == self.minimum :
            self.minimum = self.stack.pop()



    def top(self) -> int:
        return self.stack[-1]


    def getMin(self) -> int:
        return self.minimum



# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(val)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
