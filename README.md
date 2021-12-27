# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack:

    def __init__(self):
        self.s = []        

    def push(self, val: int) -> None:
        if len(self.s)==0:
            self.s.append((val,val))
            return 
        s1=self.s[-1][1]
        self.s.append((val,min(s1,val)))

    def pop(self) -> None:
        self.s.pop()

    def top(self) -> int:
        return self.s[-1][0]

    def getMin(self) -> int:
        return self.s[-1][1]


