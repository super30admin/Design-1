# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# We maintained a seperate pointer for storing curr_min and also maintained a seperate list for mins. This helped us perform getMin() in O(1) Time Complexity.


class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.min:
            val = min(val, self.min[-1])
        self.min.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.min.pop()
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min[-1]
        