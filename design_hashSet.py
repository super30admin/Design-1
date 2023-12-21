"""/*
    ## Problem 1: Design HashSet https://leetcode.com/problems/design-hashset/

    Approach
*/"""


class MyHashSet:

    def __init__(self):
        self.hashSet = []

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.hashSet.append(key)

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.hashSet.remove(key)

    def contains(self, key: int) -> bool:
        return True if key in self.hashSet else False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)