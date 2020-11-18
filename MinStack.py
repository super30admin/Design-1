# Design MinStack (https://leetcode.com/problems/min-stack/)
# Time complexity: O(1); all opeartions
# Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Approach: Use one more stack to store min elements

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        
    def push(self, x: int) -> None:
        if not self.stack:
            self.stack.append((x,x))
        else:
            self.stack.append( (x, min( x, self.getMin() )) )
        
    def pop(self) -> None:
        val = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]
    
    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()