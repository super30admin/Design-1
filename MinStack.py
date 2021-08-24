# -*- coding: utf-8 -*-
"""
Created on Tue Aug 17 19:15:04 2021

@author: amido
"""

class MinStack:

        
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = []
    

    def push(self, val: int) -> None:
        #pushing at the end of array list
        self.stack.append(val)
        
        #first push
        if not self.min_stack:
            self.min_stack.append(val)
            return

        min_val = self.min_stack[-1]
        
        #print(min_val,val)
        
        if min_val <= val:
            self.min_stack.append(min_val)
        else:
            self.min_stack.append(val)
         
        #print("push--",self.stack, self.min_stack)

    def pop(self) -> None:
        #O(1) since we pop from the last element
        self.stack.pop()
        self.min_stack.pop()
        #print("pop --", self.stack, self.min_stack)

    def top(self) -> int:
        #print("top--",self.stack[-1])
        return self.stack[-1]
    

    def getMin(self) -> int:
        #since it will be called on non-empty - provided
        #print("getmin- ",self.min_stack[-1])
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()