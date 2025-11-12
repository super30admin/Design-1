# Leetcode username: shreyagoyal06
# To prevent extra storage use, setting the size for primary and secondary hash sets as the square root of the highest number +1 (to include the upper value as well)
# All methods have O(1) complexity
# Creating one hash set which has the pointers/references to the secondary sets
# Creating secondary sets only if needed (for values with the same remainders)
# Then, following a similar approach for all operations- adding a key to that position, or removing it, or checking if the key is there at that particular position


import math

class MyHashSet:

    def __init__(self):
        self.primary_size = int(math.sqrt(10**6)) + 1  # 1001
        self.secondary_size = int(math.sqrt(10**6)) + 1  # 1001
        self.buckets = [None] * self.primary_size

    def add(self, key: int) -> None:
        h1 = key % self.primary_size
        h2 = key // self.secondary_size

        if self.buckets[h1] is None:
            self.buckets[h1] = [False] * self.secondary_size
        self.buckets[h1][h2] = True

    def remove(self, key: int) -> None:
        h1 = key % self.primary_size
        h2 = key // self.secondary_size

        if self.buckets[h1] is not None:
            self.buckets[h1][h2] = False

    def contains(self, key: int) -> bool:
        h1 = key % self.primary_size
        h2 = key // self.secondary_size

        return self.buckets[h1] is not None and self.buckets[h1][h2]
