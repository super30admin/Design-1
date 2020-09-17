# Time Complexity: O(N)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list1 = []
        self.list2 = []

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        if key in self.list1:
            self.list2[self.list1.index(key)] = value
        else:
            self.list1.append(key)
            self.list2.append(value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if key in self.list1:
            idx = self.list1.index(key)
            return self.list2[idx]
        else:
            return -1
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        if key in self.list1:
            idx = self.list1.index(key)
            self.list1.remove(key)
            self.list2.pop(idx)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
