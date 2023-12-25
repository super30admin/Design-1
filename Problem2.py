# Time Complexity :  O(1)  (when initilizing a vertical it will take O(hash1))
# Space Complexity :  O(self.size)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Dynamically allocating the array instead of initiazing at the beginning

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.min_stack[-1]:
            self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]
