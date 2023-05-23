# Time Complexity : O(1) for all operations
# Space Complexity : O(n) for the stack and O(N) for tracking the minimum values, where N < n and represents each subsequent lesser value encountered in the stack.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here I keep track of the changes in the minimum value seen so far for each index.
# To optimize the space used to track this, I only store the minimum most value when it changes.
# To make sure these minimums are popped at the right time, I keep track of the new minimum value as well as the index it was observed.

class MinStack:

    def __init__(self):
        self.stack = []
        self.mins = [(float('inf'), -1)]

    def push(self, val: int) -> None:
        self.stack.append(val)
        if val < self.mins[-1][0]:
            self.mins.append((val, len(self.stack)-1))

    def pop(self) -> None:
        if len(self.stack)-1 == self.mins[-1][1]:
            self.mins.pop()
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.mins[-1][0]
