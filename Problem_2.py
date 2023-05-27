#  Time Complexity : push = O(1), pop = O(1), top = O(1), getMin = O(1)
#  Space Complexity : O(n), where n is the number of elements in stack
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack_list = list()
        self.min_stack = list()

    def push(self, val: int) -> None:
        self.stack_list.append(val)
        if self.min_stack == [] or self.min_stack[-1] > val:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])

    def pop(self) -> None:
        self.stack_list.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack_list[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]