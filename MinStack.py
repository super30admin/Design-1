#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 18 10:22:19 2019

@author: tanvirkaur
"""

# Implementing min stack using two stack, In this approach for every value that we push into the stack we push the corresponding  minimum value into the other stack.
# Time complexity = O(1) , Space complexity = O(n)
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack =[]
        self.min = []

    def push(self, x: int) -> None:
        if len(self.min) == 0:
            self.min.append(x)
        else:
            if x <= self.min[-1]:
                self.min.append(x)
        self.stack.append(x)

    def pop(self) -> None:
        if len(self.stack)!=0:
            tmp = self.stack.pop()
            if tmp == self.min[-1]:
                self.min.pop()
            
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min[-1]