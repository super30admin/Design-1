# Time Complexity :  O(1)
# Space Complexity : 0(n)

# Did this code successfully run on Leetcode : 
# YEs
#   Runtime: 52 ms, faster than 97.16% of Python3 online submissions for Min Stack.
# Memory Usage: 17.9 MB, less than 98.55% of Python3 online submissions for Min Stack.


# Any problem you faced while coding this : 

#    Yes, my main programming lang is python so instruction was not clear

# Your code here along with comments explaining your approach

import math
class MinStack:
    #maintianing stack as well as minstack minn       
    def __init__(self):
        self.s = []
        self.mins = []
        self.minsm = math.inf    #very large number, Infinity

    def push(self, val: int) -> None:
        if val < self.minsm:
            self.minsm = val
        self.mins.append(self.minsm)
        self.s.append(val)
     

    def pop(self) -> None:
        self.s.pop()
        self.mins.pop()
        if len(self.mins):
            self.minsm = self.mins[-1]
        else:
            self.minsm = math.inf
        

    def top(self) -> int:
        return self.s[-1]

    def getMin(self) -> int:
        return self.mins[-1]