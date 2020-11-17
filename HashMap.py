# Time Complexity - O(1) for all operations

# Space Complexity - O(n) where n is the number of unique keys

# The code successfully ran on Leetcode

#Code
# I used the python dictionary data structure to create the Hashmap.
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashMap = {}

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.hashMap[key] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if key in self.hashMap:
            return self.hashMap[key]
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        return self.hashMap.pop(key, None)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)