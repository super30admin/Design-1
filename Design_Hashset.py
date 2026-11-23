#Time Complexity :O(1000)
#Space Complexity :O(1000)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Got a little confused when using the `self` keyword. 

•
#Implementing hashset without built-in libraries
#Double hashing to handle collisions
#Secondary buckets are allocated on demand


class MyHashSet:

    def __init__(self):
        self.primary_size = 1000
        self.secondary_size = 1000
        # We create the main buckets here, and inner buckets only when needed.
        self.storage = [None] * self.primary_size

    def h1(self, key):
        # Remainder gives the primary bucket index.
        return key % self.primary_size

    def h2(self, key):
        # Quotient gives the index inside that bucket.
        return key // self.secondary_size

    def add(self, key: int) -> None:
        primary = self.h1(key)

        # If this bucket is not created yet, we create it now.
        if self.storage[primary] is None:
            size = self.secondary_size + 1 if primary == 0 else self.secondary_size
            self.storage[primary] = [False] * size

        secondary = self.h2(key)
        # Mark this key as present.
        self.storage[primary][secondary] = True

    def remove(self, key: int) -> None:
        primary = self.h1(key)

        # If bucket is not there, the key is also not present.
        if self.storage[primary] is None:
            return

        secondary = self.h2(key)
        # Mark this key as removed.
        self.storage[primary][secondary] = False

    def contains(self, key: int) -> bool:
        primary = self.h1(key)

        # No bucket means this key was not added.
        if self.storage[primary] is None:
            return False

        secondary = self.h2(key)
        # Return whether this key is present or not.
        return self.storage[primary][secondary]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
