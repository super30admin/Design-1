# Leetcode Problem No 705
# Time Complexity : O(1)
# Space Complexity : O(1)
# Runtime: 107ms

class MyHashSet:

    def __init__(self):
        self.myHashSet = set()

    def add(self, key: int) -> None:
        self.myHashSet.add(key)

    def remove(self, key: int) -> None:
        if key in self.myHashSet:
            self.myHashSet.remove(key)

    def contains(self, key: int) -> bool:
        if key in self.myHashSet:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)