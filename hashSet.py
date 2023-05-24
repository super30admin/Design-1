# Time Complexity: O(1) for all operations. The worst case time complexity is O(n) if there are hash collisions and multiple elements are mapped to the same hash bucket
# Space Complexity: O(1), since it uses array with constant size

# The code ran on Leetcode

class MyHashSet:

    def __init__(self):
        # Initialize an empty list
        self.size = 1000
        self.list = [[] for _ in range(self.size)]

    def add(self, key: int) -> None:
        # Simple hash function to map keys to bucket indices
        index = key % self.size

        # Append key if it is not present in the corresponding index
        if not self.contains(key):
            self.list[index].append(key)

    def remove(self, key: int) -> None:
        index = key % self.size
        if self.contains(key):
            self.list[index].remove(key)

    def contains(self, key: int) -> bool:
        index = key % self.size
        return key in self.list[index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)