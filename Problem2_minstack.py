'''
Time complexity: O(1) for push, pop, top, getmin, for pop worst case is O(n)
Space Complexity: 0(n)
Successfully submitted on leetcode
'''
import math
class MinStack:

    def __init__(self):
        self.stack = list()
        # initializing the minimum value as infinity so that the first element to be pushed always gets pushed
        self.min_val = math.inf

    def push(self, val: int) -> None:
        # for the first time minimum value will always be greater thus will get pushed.
        if self.min_val >= val:
            self.stack.append(self.min_val)

            self.min_val = val
        self.stack.append(val)

    def pop(self) -> None:
        if self.min_val == self.stack.pop():
            self.min_val = self.stack.pop()

    def top(self) -> int:
        return self.stack[len(self.stack) - 1]

    def getMin(self) -> int:
        return self.min_val

