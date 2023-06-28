# Time Complexity : O(1) for all the methods
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Approach:
# if the next element to be pushed is lesser than or equal to current minimum,
# push the current minimum as well and then update it with new element.
# this way, even when the current minimum is popped, the previous minimum can be retrieved.

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = 2**31 #maintains the minimum at any point

    def push(self, val: int) -> None: #O(1)
        if val <= self.min:
            self.stack.append(self.min) #appending the min before updating it, 
            # so that it can be retrieved if the next min is popped
            self.min = val #update the current minimum
        self.stack.append(val)

    def pop(self) -> None: #O(1)
        if self.stack.pop() == self.min:
            self.min = self.stack.pop() #updating the previous min

    def top(self) -> int: # O(1)
        return self.stack[-1]
        
    def getMin(self) -> int: #O(1)
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()