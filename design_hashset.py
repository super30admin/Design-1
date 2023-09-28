# Q. Design Hashset
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class MyHashSet(object):
    def __init__(self):    # TC = O(1), SC = O(1)
        self.primary = 1000
        # primary array of size 1000
        self.primary_array = [None] * self.primary
        self.secondary = 1000

    def hash1(self, key):  # hash func 1
        return key % self.primary

    def hash2(self, key):  # hashing func 2
        return key//self.secondary

    def add(self, key):  # TC = O(1), SC = scales with input.
        """
        :type key: int
        :rtype: None
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        # if hash1 is null, means there is no nested array at that idx. In that case initialize a boolean nested array at idx = hash1
        if self.primary_array[hash1] is None:
            self.primary_array[hash1] = [False] * self.secondary
        # else: set True at hash2 idx in nested array
        self.primary_array[hash1][hash2] = True
        return

    def remove(self, key):  # TC = O(1), SC = O(1)
        """
        :type key: int
        :rtype: None
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        # if no nested array at hash1 idx, return null
        if self.primary_array[hash1] is None:
            return
        # else: set flag to False at idx = hash2
        self.primary_array[hash1][hash2] = False
        return

    def contains(self, key):  # TC = O(1), SC = O(1)
        """
        :type key: int
        :rtype: bool
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        # if no nested array at hash1 idx, return null
        if self.primary_array[hash1] is None:
            return
        # else retrieve the flag using hash1 & hash2 from the nested array & return
        return self.primary_array[hash1][hash2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
