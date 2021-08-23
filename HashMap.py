"""
Time Complexity:
    * __init__  : O(1)
    * put       : O(1)
    * get       : O(1)
    * remove    : O(1)

Space Complexity:
    * __init__  : O(1)
    * put       : O(1)
    * get       : O(1)
    * remove    : O(1)

Pass on LeetCode: Yes
Problems Occurred: N/A
"""


class MyHashMap:
    def __init__(self):
        self.mappings = [-1] * 1000001

    def put(self, key: int, value: int) -> None:
        self.mappings[key] = value

    def get(self, key: int) -> int:
        return self.mappings[key]

    def remove(self, key: int) -> None:
        self.mappings[key] = -1
