# Creating two stacks and pushing in minstack only
# when the new element is smaller or equal to min.
# Pop only when new element is equal to min.

from collections import deque


class MinStack:
    def __init__(self):
        self.stack = deque()
        self.minStack = deque()
        self.min = float("inf")

    def push(self, val: int) -> None:
        self.stack.append(val)

        # only appending if new val is less than or equal to min
        if val <= self.min:
            self.minStack.append(val)
            self.min = val

    def pop(self) -> None:
        poppedNum = self.stack.pop()
        # popping only when both stacks have the same top element
        if poppedNum == self.minStack[-1]:
            self.minStack.pop()
            # setting new min conditions
            if len(self.minStack):
                self.min = self.minStack[-1]
            else:
                self.min = float("inf")

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
