"""
Time Complexity: O(1)
Space Complexity: O(n)
Did this code run successfully on leetcode: No, this problem was slightly different than the one on leetcode.

Problem: 
Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin() 
which should return minimum element from the SplStack. All these operations must be O(1). To implement this, 
you should only use standard Stack data structure.
"""
import sys

# One stack solution
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s1 = []
        self.min = sys.maxsize 
        
    def push(self, x: int) -> None:
        if x <= self.min:
            self.s1.append(self.min)
            self.min = x
        self.s1.append(x)
        
    def pop(self) -> None:
        p = self.s1.pop()
        if p == self.min:
            self.min = self.s1.pop()
        
    def top(self) -> int:
        return self.s1[-1]

    def getMin(self) -> int:
        return self.min

# Testing 
s = MinStack()
print(s.getMin())
s.push(6)
s.push(8)
s.push(-10)
s.push(1)
s.push(12)

s.push(5)
print(s.pop())
s.push(16)
print("Min: {0}".format(s.getMin()))
print(s.pop())
print(s.pop())
print("Min: {0}".format(s.getMin()))
print(s.pop())
print("Min: {0}".format(s.getMin()))
print(s.pop())
print("Min: {0}".format(s.getMin()))
print(s.pop())
print("Popping: " + str(s.pop()))