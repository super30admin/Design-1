"""
Time Complexity:
    - Put - O(n)
    - get - O(n)
    - Remove - O(n)
Space Complexity:
    - Size of the array - 1000000
YES, The code successfully ran on Leetcode
I faced a lot of problems especially learning how efficient should my hashing key should be. I would
love to know the most effecient ans and how to approach the collision problem.


Approach - My approach is pretty straight forward, I am making a hash function by modulus by size.
and then storing the key on the hash key index, if the key exist then update but if not then add it
into the bucket at index.
"""


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000000
        self.hashmap = [None] * self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashed = key % self.size
        if self.hashmap[hashed] is None:
            self.hashmap[hashed] = [(key, value)]
        else:
            for i in range(len(self.hashmap[hashed])):
                if self.hashmap[hashed][i][0] == key:
                    self.hashmap[hashed][i] = (key, value)
                    return
            self.hashmap[hashed].append((key, value))

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashed = key % self.size
        if self.hashmap[hashed] is None:
            return -1
        else:
            for i in range(len(self.hashmap[hashed])):
                if self.hashmap[hashed][i][0] == key:
                    return self.hashmap[hashed][i][1]
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashed = key % self.size

        if self.hashmap[hashed] is not None:
            if len(self.hashmap[hashed]) == 1:
                self.hashmap[hashed] = None
            else:
                for i in range(len(self.hashmap[hashed])):
                    if self.hashmap[hashed][i][0] == key:
                        self.hashmap[hashed].pop(i)
                        break