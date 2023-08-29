# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

from math import inf


class MinStack:

    def __init__(self):
        self.stack = []           # stack for stack
        self.minstack = []      # stack for min
        self.min = inf          # min = infinite
        self.minstack.append(self.min)  # added min at initial

    def push(self, val: int) -> None:
        self.stack.append(val)           # append value in stack
        self.min = min(self.min,val)   
        self.minstack.append(self.min) # append min in minstack stack

    def pop(self) -> None:
        self.stack.pop()                 # pop from stack
        self.minstack.pop()             # pop from minstack
        self.min = self.minstack[-1]    # assigned last value of minstack to min

    def top(self) -> int:
        return self.stack[-1]        # return top of stack

    def getMin(self) -> int:
        return self.minstack[-1]  # return min of minstack