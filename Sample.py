// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)
// My approach:
The set is initialized with a fixed size of 1000001,
add, remove, contains checking the boolean value at the index at the corresponding key.

class MyHashSet:

    def __init__(self):
        self.set = [False] * 1000001
        
    def add(self, key: int) -> None:
        self.set[key] = True

    def remove(self, key: int) -> None:
        self.set[key] = False

    def contains(self, key: int) -> bool:
        return self.set[key]

Time Complexity : 0(1), Space Complexity: 0(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : nope




## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
// My approach:
Initialize two list stack and for min_val
Every time when we push a new element we need to update a min_val
and we need to so the same for pop as well

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_val = []

    def push(self, val: int) -> None:
        self.stack += [val]
        if self.min_val:
            self.min_val += [min (val, self.min_val[-1])]
        else:
            self.min_val += [val]

    def pop(self) -> None:
        self.stack = self.stack[:-1]
        self.min_val = self.min_val[:-1]

    def top(self) -> int:
         return self.stack[-1]

    def getMin(self) -> int:
        return self.min_val[-1]

Time Complexity : 0(1), Space Complexity: 0(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : nope



