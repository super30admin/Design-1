class MyHashSet:

    def __init__(self):
        self.set = [False] * (10 ** 6 + 1)

    def add(self, key: int) -> None:
        self.set[key] = True

    def remove(self, key: int) -> None:
        self.set[key] = False

    def contains(self, key: int) -> bool:
        return self.set[key]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

# Time complexity -
# add	O(1)
# remove	O(1)
# contains	O(1)

# Space Complexity = O(10^6)