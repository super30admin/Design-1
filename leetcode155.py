#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Feb  3 22:02:35 2026

@author: rishigoswamy

    Approach:
    ----------
    This stack supports push, pop, top, and getMin in O(1) time.

    The idea is to store previous minimum values inside the same stack.
    Whenever a new value is pushed that is smaller than or equal to the
    current minimum, we first push the old minimum onto the stack and
    then update the minimum to the new value.

    This allows us to restore the previous minimum in O(1) time when
    the current minimum is popped.
    
    Time Complexity:
    ----------------
    push    : O(1)
    pop     : O(1)
    top     : O(1)
    getMin  : O(1)

    Space Complexity:
    -----------------
    O(n), where n is the number of elements in the stack.
    
"""

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')
        
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
           
    def pop(self) -> None:
        if(self.stack.pop() == self.min):
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()