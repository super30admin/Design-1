#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 25 16:58:49 2021

@author: ameeshas11
"""
#Time Complexity : O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : No, it runs correctly for sample testcases 
#but on submitting it shows wrong ans, I cant figure out the problem
#Any problem you faced while coding this :
    
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.st = []
        self.min_st = []
        self.min_val = None

    def push(self, val: int) -> None:
        #append the value on stack
        self.st.append(val)
        #set minimum value in a variable
        if self.min_val == None:
            self.min_val = val
        else:
            if val<self.min_val:
                self.min_val = val
        #append min val for each element in stack
        self.min_st.append(self.min_val)
        
    def pop(self) -> None:
        #pop one element from both stacks
        top = len(self.st) - 1
        del self.st[top]
        del self.min_st[top]
        

    def top(self) -> int:
        #return the topmost element on stack
        top = len(self.st) - 1
        return self.st[top]

    def getMin(self) -> int:
        #return the topmost element on minStack
        top = len(self.st) - 1
        return self.min_st[top]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()