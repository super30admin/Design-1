''' Time Complexity : O(1) for all the operations
    Space Complexity : O(n) ; where n is no of elements and we are maintaining the stack
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : Maintaining the one to one mapping between stack and min_stack,
                to keep the track of previous minimums.
'''


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.min=float("infinity")

    def push(self, val: int) -> None:
        self.stack.append(val)
        if val < self.min:
            self.min=val
        self.min_stack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()
        if self.min_stack:
            self.min = self.min_stack[-1]
        else:
            self.min = float("infinity")

        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min_stack[-1]
        

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()