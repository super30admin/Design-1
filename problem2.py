from collections import deque
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=deque()
        self.mini=float('inf')
        

    def push(self, x: int) -> None:                 # Time Complexity : O(1)
        if self.mini >=x:
            self.stack.append(self.mini)
            self.mini=x
        self.stack.append(x)
            

    def pop(self) -> None:                          # Time Complexity : O(1)
        popped=self.stack.pop()
        if popped==self.mini:
            self.mini=self.stack.pop()
        

    def top(self) -> int:                           # Time Complexity : O(1)
        return self.stack[-1]
        

    def getMin(self) -> int:                       # Time Complexity : O(1)
        return self.mini
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()



// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


