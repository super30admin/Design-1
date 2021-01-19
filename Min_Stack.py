import sys
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minimum = sys.maxsize

    def push(self, x: int) -> None:
        
        if x <= self.minimum:
            # add min value to the stack
            self.stack.append(self.minimum)
            # update min to x
            self.minimum = x
            # add x to the stack
            self.stack.append(x)
        else:
            # add x to the stack
            self.stack.append(x)

    def pop(self) -> None:
        
        elem = self.stack.pop()
        # check if the min is equal to the popped elem
        if elem == self.minimum:
            # update the min to next popped elem
            self.minimum = self.stack.pop()
        

    def top(self) -> int:
        # return the last elem of the stack
        topelem = self.stack[-1]
        return topelem

    def getMin(self) -> int:
        return self.minimum


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()