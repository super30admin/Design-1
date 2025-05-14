Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

## // Time Complexity : O(1)
## // Space Complexity : O(n)
## // Did this code successfully run on Leetcode : yes
## // Any problem you faced while coding this : no
class MyHashSet:

    def __init__(self):
        self.size = 10
        self.hashset = [[] for _ in range(self.size)]

    def add(self, key: int) -> None:
        hash_key = key % self.size
        if key not in self.hashset[hash_key]:
            self.hashset[hash_key].append(key)

    def remove(self, key: int) -> None:
        hash_key = key % self.size
        if key in self.hashset[hash_key]:
            self.hashset[hash_key].remove(key)

    def contains(self, key: int) -> bool:
        hash_key = key % self.size
        if key in self.hashset[hash_key]:
            return True
        else:
            return False
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

## // Time Complexity : O(1)
## // Space Complexity : O(n)
## // Did this code successfully run on Leetcode : yes
## // Any problem you faced while coding this : no
class MinStack:

    def __init__(self):
        self.main_stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.main_stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)


    def pop(self) -> None:
        if self.main_stack:
            popped = self.main_stack.pop()
            if popped == self.min_stack[-1]:
                self.min_stack.pop()

    def top(self) -> int:
        if len(self.main_stack):
            return self.main_stack[-1]
        
    def getMin(self) -> int:
        if len(self.min_stack):
            return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


