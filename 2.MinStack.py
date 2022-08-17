# Time Complexity : all operations O(1)
# Space Complexity : all operations O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No problem faced


# Your code here along with comments explaining your approach: 2 stack approach, 1:1 mapping in 2 stacks to keep track of minimum
class MinStack:
    
    def __init__(self):
        self.Stk = []
        self.minStk = []
        self.m = float("inf")
        self.minStk.append(self.m)

    def push(self, val: int) -> None:
        self.m = min(self.m, val)
        self.Stk.append(val)
        self.minStk.append(self.m)

    def pop(self) -> None:
        # if self.Stk:
            self.Stk.pop()
            self.minStk.pop()
            self.m = self.minStk[len(self.minStk)-1]
        # return self.

    def top(self) -> int:
        return self.Stk[len(self.Stk)-1]
        

    def getMin(self) -> int:
        return self.m
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()