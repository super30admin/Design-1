"""
Time Complexity -> O(1) for push, pop, top and getMin
Space Complexity -> O(n) where n is the number of elements in stack

We insert elements as a tuple of the form [value, minimum(value, top of stack minimum)] to keep
track of minimums at each point.
Also improved runtime by keeping a counter variable so that we do not have to call len()
over and over again to check if stack is empty/ not
"""


class MinStack:

    def __init__(self):
        self.stack = []
        self.counter = 0

    def push(self, val: int) -> None:
        if self.counter == 0:
            self.stack.append([val, val])
        else:
            self.stack.append([val, min(val, self.getMin())])
        self.counter += 1

    def pop(self) -> None:
        if self.counter != 0:
            self.stack.pop()
            self.counter -= 1

    def top(self) -> int:
        if self.counter != 0:
            return self.stack[-1][0]

    def getMin(self) -> int:
        if self.counter != 0:
            return self.stack[-1][1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
