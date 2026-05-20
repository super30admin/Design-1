'''
To keep track of the minimum value in the stack we puch the previous minimum value
on the stack before pushing the new minimum value. 
This helps in keeping track of the minimum value of the stack that is remaining.

While popping we see if the popped value was the minimum, if so then we also pop the previous minimum that
we pushed while adding element to the stack.

min variable keeps track of the current minimum value of the stack.
'''
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float(inf)

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val

        self.stack.append(val)

    def pop(self) -> None:
        poppedVal = self.stack.pop()

        if poppedVal == self.min:
            self.min = self.stack.pop()

        return poppedVal

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()