# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


class MinStack:

    def __init__(self):
        self.stack=[]
        self.min_stack=[]
        self.min_val=2147483647
        self.min_stack.append(self.min_val)

    def push(self, val: int) -> None:
        self.stack.append(val)
        minimum=min(self.min_val,val)
        self.min_stack.append(minimum)
        self.min_val=minimum
            

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()
        self.min_val=self.min_stack[-1]

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_val


