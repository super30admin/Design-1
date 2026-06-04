# Problem 1: Design HashSet
# Time Complexity: O(1) for all operations - add, remove, contains
# Space Complexity: O(n) n is number of unique keys
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: Faced error in some syntax

class MyHashSet(object):
    def __init__(self):
        self.initial_bucket = 1000
        self.secondary_bucket = 1000
        self.storage = [None] * self.initial_bucket

    def hash_func1(self, key):
        return key % self.initial_bucket

    def hash_func2(self, key):
        return key // self.secondary_bucket

    def add(self, key):
        bucket = self.hash_func1(key)
        internal_bucket = self.hash_func2(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.secondary_bucket + 1)
            else:
                self.storage[bucket] = [False] * self.secondary_bucket
        self.storage[bucket][internal_bucket] = True

    def remove(self, key):
        bucket = self.hash_func1(key)
        internal_bucket = self.hash_func2(key)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][internal_bucket] = False

    def contains(self, key):
        bucket = self.hash_func1(key)
        internal_bucket = self.hash_func2(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][internal_bucket]


# Problem 2: Min Stack
# Time Complexity: O(1) for all operations - push, pop, top, getMin
# Space Complexity: O(n) 
# Did this code successfully run on Leetcode: YES, but needed to take reference from solution to understand the approach
# Any problem you faced while coding this: Understanding the two stack approach

class MinStack:
    def __init__(self):
        self.main_stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.main_stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])

    def pop(self) -> None:
        self.main_stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.main_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]