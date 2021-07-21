"""
Time Complexity:
    - Put - O(1)
    - get - O(1)
    - Remove - O(1)
Space Complexity:
    - Size of the array - 10^3 * 10^3
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am making a hash function by modulus by size.
and then storing the key on the key // size index, if the key exist then update but if not then add it
into the bucket at double hashed index.
"""


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.hashmap = [None] * self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashed = key % self.size
        if self.hashmap[hashed] is None:
            if hashed == 0:
                self.hashmap[hashed] = [None] * 1001
            else:
                self.hashmap[hashed] = [None] * 1000
        double_hashed = key // self.size
        self.hashmap[hashed][double_hashed] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashed = key % self.size
        if self.hashmap[hashed] is None:
            return -1
        else:
            double_hashed = key // self.size
            if self.hashmap[hashed][double_hashed] is None:
                return -1
            else:
                return self.hashmap[hashed][double_hashed]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashed = key % self.size
        if self.hashmap[hashed] is not None:
            double_hashed = key // self.size
            if self.hashmap[hashed][double_hashed] is not None:
                self.hashmap[hashed][double_hashed] = None