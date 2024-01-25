# Time Complexity : o(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Not in this problem

# Done with simple dictionary operation


from collections import defaultdict


class MyHashSet:

    def __init__(self):
        self.mp = defaultdict(int)

    def add(self, key: int) -> None:
        self.mp[key] = True

    def remove(self, key: int) -> None:
        self.mp[key] = False

    def contains(self, key: int) -> bool:
        return self.mp[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
