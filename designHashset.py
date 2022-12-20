# Exercise_1: Design Hashset
# Time Complexity: O(1) for add, remove and contains
# Space Complexity: O(1) since we use a 2D array of size 1000
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/design-hashset/)
# Challenges: None

# Coding Approach:
# Instead of using a 1D array of size 1000000 (since 0 <= key <= 10^6), we use a 2D array of size 1000, each with 1000 elements. 
# Contains: Check which subarray the key belongs to and check if the key is present in that subarray.
# Add: Check which subarray the key belongs to and if the key is not present in that subarray, then add the key to that subarray.
# Remove: Check which subarray the key belongs to and if the key is present in that subarray, then remove the key from that subarray.

class MyHashSet:

    def __init__(self):
        # Initialize a 2D array of size 1000
        self.hashset = [[] for _ in range(1000)]

    def add(self, key: int) -> None:
        k = key % 1000
        # If the key is not present in hashset[k], add it
        if not self.contains(key):
            self.hashset[k].append(key)

    def remove(self, key: int) -> None:
        k = key % 1000
        # If the key is present in hashset[k], remove it
        if self.contains(key):
            self.hashset[k].remove(key)

    def contains(self, key: int) -> bool:
        k = key % 1000
        # Return True if key is present in hashset[k]
        return key in self.hashset[k]

