# Time Complexity: O(n)
# Space Complexity: O(n)
#Did this code successfully run on Leetcode : Yes
class MyHashSet:

    def __init__(self):
        self.hashset = set()  # Initializing a set

    def add(self, key: int) -> None:
        self.hashset.add(key)

    def remove(self, key: int) -> None:
        if key in self.hashset:
            self.hashset.remove(key)

    def contains(self, key: int) -> bool:
        if key in self.hashset:
            return True
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)