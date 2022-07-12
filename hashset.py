# Time Complexity: O(1)
# Space Complexity: O(n)
# Did code run on Leetcode: Yes
# Approach: Based on the range of inputs, to avoid collisions and keep contains, add, search operation to O(1), we design this double hashing Hashset.
# Based on the input range, we take primary and secondary lists, both of size sqrt(range). This is a hack which ensures collisions are avoided.

# In these Hashing problems, there is always a decision to be taken between Time and Space complexity.

# We initialize secondary array only when the key corresponding to it's primary array is filled.


class MyHashSet:
    def __init__(self):
        self.mainArray = 1000
        self.nestedArray = 1000

        # Initializing primary array as None of size sqrt(range)
        self.hashset = [None] * self.mainArray

    def firstHash(self, key: int) -> int:
        return key % 1000

    def secondHash(self, key: int) -> int:
        return key // 1000

    def add(self, key: int) -> None:
        hash_1 = self.firstHash(key)
        hash_2 = self.secondHash(key)

        # Checking if Primary Hash list is filled
        if self.hashset[hash_1] is None:
            if hash_1 == 0:

                # Edge case for input 10 ^ 6. Array is has last index 999. We need to input at index 1000

                self.hashset[hash_1] = [None] * (self.nestedArray + 1)
            else:

                # Initializing secondary array only when primary array has key. Saves us space
                self.hashset[hash_1] = [None] * (self.nestedArray)

        self.hashset[hash_1][hash_2] = True

    def remove(self, key: int) -> None:
        hash_1 = self.firstHash(key)
        hash_2 = self.secondHash(key)

        # If primary itself is empty, then no need to check secondary

        if self.hashset[hash_1] is None:
            return
        else:
            self.hashset[hash_1][hash_2] = False

    def contains(self, key: int) -> bool:
        hash_1 = self.firstHash(key)
        hash_2 = self.secondHash(key)
        if self.hashset[hash_1] is None:
            return False
        return self.hashset[hash_1][hash_2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
