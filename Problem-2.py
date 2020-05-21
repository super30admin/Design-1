"""
## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.


"""
#using two stacks

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.minstack = []
        self.min = float('inf')

    def push(self, x: int) -> None:

        if x < self.min:
            self.min = x
        self.stack.append(x)

        self.minstack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        if self.minstack:
            self.min = self.minstack[-1]
        else:
            self.min = float('inf')

    def top(self) -> int:
        if self.stack == None:
            return None
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()



#1 stack
class Minstack:
    def __init__(self):
        self.stack=[]
        self.min=float('inf')

    def push(self, x: int) -> None:
        if x <= self.min:
            self.stack.append(self.min)
            x = self.min
        self.stack.append(x)

    def pop(self,x):
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        if self.stack == None:
            return None
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min
