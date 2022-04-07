'''https://leetcode.com/problems/min-stack
 Design a SplStack that supports all the stack operations push, pop, 
 isEmpty, isFull and an operation getMin() which should return 
 minimum element from the SplStack. All these operations must be O(1).
'''
# Time Complexity : O(1) all operations
# Space Complexity : O(N) for N elements inserted to Stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from collections import deque


class MinStack:

    def __init__(self):
        self.stk = deque()
        self.min = float('inf') # so that first input element is always min
    
    
    def push(self, val: int) -> None:
        if val <= self.min: # Imp: '<=' for duplicate min value
            self.stk.append(self.min) # push prev min (as a memory)
            self.stk.append(val) # push the new val
            self.min = val # update with new min
        else:
            self.stk.append(val) # only push the new val


    def pop(self) -> None:
        top_element = self.stk.pop()
        if top_element == self.min:
            # update new min
            self.min = self.stk.pop()
    
    
    def top(self) -> int:
        return self.stk[-1]
        

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()