# // Time Complexity : O(1)
# // Space Complexity : O(1000)
# // Did this code successfully run on Leetcode : Yes

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [-1] * 1000

    def getHash(self, key):
        return key % 1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashValue = self.getHash(key)
        self.hashmap[hashValue] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashValue = self.getHash(key)
        return self.hashmap[hashValue]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashValue = self.getHash(key)
        self.hashmap[hashValue] = -1

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)