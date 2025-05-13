# Author : Akaash Trivedi
# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes #705
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.keySize = 997
        self.bucket =[[] for _ in range(self.keySize)]

    def hash(self, key) -> None:
        return key % self.keySize

    def add(self, key: int) -> None:
        index = self.hash(key)
        if key not in self.bucket[index]:
            self.bucket[index].append(key)

    def remove(self, key: int) -> None:
        index = self.hash(key)
        if key in self.bucket[index]:
            self.bucket[index].remove(key)

    def contains(self, key: int) -> bool:
        index = self.hash(key)
        return key in self.bucket[index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)