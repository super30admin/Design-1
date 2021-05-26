# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map = [-1] * (10 ** 6 + 1)

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.map[key] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.map[key]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.map[key] = -1


if __name__ == '__main__':
    obj = MyHashMap()
    obj.put(2,3)
    param_2 = obj.get(2)
    obj.put(2,5)
    obj.remove(2)
