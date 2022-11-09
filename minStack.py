# Time Complexity: 
# Push Operation  = O(!)
# Pop Operation = O(1)
# Top Operation= O(1)
# getMin Operation = O(1)
# Space Complexity: O(n) where n is the length of the stack 

from cmath import inf
import math

# Approach 1 : Min stack using a single stack, that can perform push, pop , top and retrive the min element in constant time. So the functions will be push(val), pop(), top(), getMin()

class MinStack:
    
    # Initialize the stack by min element as infinity
    def __init__(self):
        self.stack = []
        self.min = math.inf
   
    # For push operation push(x) 
    def push(self, val: int) -> None:
        #if val < min, then update min:= val
        #push val in stack
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
    
    # For pop operation
    def pop(self) -> None:
        #stack[-1] = top element
        # delete top from stack
        #if top is min, then min = top element of the stack
        # pop the top element and return 
        if self.stack[-1] != math.inf: 
            pop_val = self.stack.pop()
            if pop_val == self.min:
                self.min = self.stack.pop()
            return pop_val
    
    # For top operation 
    # return top element : here stack[-]
    def top(self) -> int:
            return self.stack[-1]
   
    # For getMin operation 
    # return self.min(min element )
    def getMin(self) -> int:
        return self.min
        