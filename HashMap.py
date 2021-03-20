# Time Complexity : O(1) for put, get and remove
# Space Complexity : O(n) for put, get and remove
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, while assigning the
#     space for lists and the list needed after double hashing.
#
#
# Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.idx_list = [None] * 10 ** 3

    def gethashq(self, key):
        return key % 10 ** 3

    def gethashr(self, key):
        return key // 10 ** 3

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashq = self.gethashq(key)
        if self.idx_list[hashq] is None:
            double_hashed_list = [None] * 1001
            self.idx_list[hashq] = double_hashed_list
        hashr = self.gethashr(key)
        self.idx_list[hashq][hashr] = value

    #         else:
    #             hashr = self.gethashr(key)
    #             self.idx_list[hashq][hashr] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashq = self.gethashq(key)
        if self.idx_list[hashq] is None:
            return -1
        else:
            hashr = self.gethashr(key)
            if self.idx_list[hashq][hashr] is not None:
                return self.idx_list[hashq][hashr]
            else:
                return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashq = self.gethashq(key)
        hashr = self.gethashr(key)
        if self.idx_list[hashq] is not None:
            if self.idx_list[hashq][hashr] is not None:
                self.idx_list[hashq][hashr] = None
        else:
            return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)