# Time Complexity : O(1) for all operations

# Space Complexity : O(2n) for two data structures - normal and min stack. Can be simplifed to O(n)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

"""
We will maintain two stacks - stack#1 will hold all incoming elements and 
stack#2 holds the minimum value based on all elements that we've seen. Underlying data structure for both is a Python array

Push
- For normal stack, we will do a basic append operation
- For min stack, pop last element and compare with incoming, if incoming is smaller then append.

Pop
- Pop min stack when value is same in normal stack else pop main stack only to keep consistent state of minimum values

Top
- Will only return element from the normal stack. As the underlying is array, we just return last element

GetMin
- Returns value from the min stack only. As the underlying is array, we just return last element
"""

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minStack or val <= self.minStack[-1]:
            self.minStack.append(val)
        
    def pop(self) -> None:
        if self.minStack[-1] == self.stack[-1]:
            self.minStack.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
