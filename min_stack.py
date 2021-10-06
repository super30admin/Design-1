# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: ✔️
# Any problem you faced while coding this: Not sure if this is the most efficient solution

class MinStack:
    def __init__(self):
        self.min_stack = []
        self.stack = []

    def push(self, val: int):
        if len(self.min_stack) == 0 or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        self.stack.append(val)

    def pop(self):
        pop = self.stack.pop()
        if self.min_stack[-1] == pop:
            self.min_stack.pop()

    def top(self):
        return self.stack[-1]

    def get_min(self) -> int:
        return self.min_stack[-1]
