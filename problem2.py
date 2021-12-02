# Time Complexity :
#   Push: O(1)
#   Pop: O(1)
#   top: O(1)
#   empty:O(1)
#   getMin:O(1)
# Space Complexity:
#     O(n)
#  Did this code successfully run on Leetcode : Yes

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = None

    def push(self, val: int) -> None:
        if self.min == None:
            self.min = val
        elif val < self.min:
            self.min = val
        self.stack.append(val)
        self.minStack.append(self.min)

    def pop(self) -> None:
        popped = self.stack.pop()
        self.minStack.pop()

        if len(self.minStack) != 0:
            self.min = self.minStack[-1]
        else:
            self.min = None

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