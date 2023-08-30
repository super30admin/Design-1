#  Time Complexity : O(1) push, pop, top, getMin
#  Space Complexity : O(n) where n is the number of elements. 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Approach: Maintain 2 stacks. One stack to hold the actual items. Another stack to maintain the minimum element at each state. 

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.counter = 0
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.counter == 0 or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        self.counter += 1
        
    def pop(self) -> None:
        val = self.stack.pop()
        if self.counter > 0 and val == self.min_stack[-1]:
            self.min_stack.pop()
        self.counter -= 1
        
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
