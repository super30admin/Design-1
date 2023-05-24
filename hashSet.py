# Time Complexity : add O(1), remove O(1), contain O(1)
# Space Complexity : add O(n), remove O(n), contain O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : learned how to implement hashset and \
# what is the difference between hashset and hashmap


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.size = 1000 # initializing array size
        self.arr = [[] for _ in range(self.size)]

    # use helper function to get compressed value with the array size
    def _hash(self, key):
        return key % self.size

    # add value in hashset if not present
    def add(self, key: int) -> None:
        index = self._hash(key)
        if key not in self.arr[index]:
            self.arr[index].append(key)

    def remove(self, key: int) -> None:
        index = self._hash(key)
        if key in self.arr[index]:
            self.arr[index].remove(key)

    def contains(self, key: int) -> bool:
        index = self._hash(key)
        return key in self.arr[index]
