// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// stores integers using a fixed number of buckets (1000), where each bucket is a list. 
// Where a _hash function maps a key to a bucket index using modulo
class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.bucketItems = [[] for i in range(self.size)]
    
    def _hash(self, key: int) -> int:
        return key % self.size 

    def add(self, key: int) -> None:
        bucket = self.bucketItems[self._hash(key)]
        if key not in bucket:
            bucket.append(key)

    def remove(self, key: int) -> None:
        bucket = self.bucketItems[self._hash(key)]
        if key in bucket:
            bucket.remove(key)

    def contains(self, key: int) -> bool:
        bucket = self.bucketItems[self._hash(key)]
        return key in bucket


// This MinStack() implements a stack that can return the minimum element in constant time.
// It keeps two stacks: stack for all values and min_stack for tracking the current minimums, pushing a value onto min_stack only if it’s smaller than or equal to the last minimum.
// When popping, it removes from both stacks if the popped value is the current minimum, so getMin() always returns the latest minimum in O(1)
 class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None: 
        latest = self.stack.pop()
        if self.min_stack[-1] == latest:
            self.min_stack.pop()
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min_stack[-1]