Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

#--------------------------------------------------------

class MyHashSet:
    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.storage = [None] * self.primaryBuckets

    def getPrimaryHash(self, key):
        return key % self.primaryBuckets

    def getSecondaryHash(self, key):
        return key // self.secondaryBuckets

    def add(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            if primaryIndex == 0:
                self.storage[primaryIndex] = [False] * (self.secondaryBuckets + 1)
            else:
                self.storage[primaryIndex] = [False] * self.secondaryBuckets
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return
        secondaryIndex = self.getSecondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key):
        primaryIndex = self.getPrimaryHash(key)
        if self.storage[primaryIndex] is None:
            return False
        secondaryIndex = self.getSecondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex]


#--------------------------------------------------------





## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)


#--------------------------------------------------------


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        if self.stack:
            if self.stack[-1] == self.min_stack[-1]:
                self.min_stack.pop()
            self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]






#--------------------------------------------------------
