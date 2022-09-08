class MyHashSet(object):
    """Single hashing function: Collision occurs
    Linked List at the element where collision occurs: O(N) loookup time
    Balanced BST instead: O(logN) lookup time
    Best: Double hashing and using secondary array: Constant lookup time.
    Range: 0-10^6 => Array size for primary and secondary arrays should be
    square root of range(10^3) to have a balance.
    Hashing function one: %
    Hashing function two: //
    Edge case: 10^6 as index of secondary array will be restricted to 999."""

    # Time Complexity of each operation is constant time.
    # Space Complexity is O(N).
    # Code submitted successfully on Leetcode.

    def __init__(self):
        self.n_buckets = 10 ** 3
        self.n_bucketitems = 10 ** 3
        self.prim_arr = [None] * self.n_buckets

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        prim_ind = key % self.n_buckets
        sec_ind = key // self.n_bucketitems
        if self.prim_arr[prim_ind] is None:
            if prim_ind == 0:
                self.prim_arr[prim_ind] = [False] * (self.n_bucketitems + 1)
            else:
                self.prim_arr[prim_ind] = [False] * self.n_bucketitems
        self.prim_arr[prim_ind][sec_ind] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        prim_ind = key % self.n_buckets
        if self.prim_arr[prim_ind] is not None:
            sec_ind = key // self.n_bucketitems
            self.prim_arr[prim_ind][sec_ind] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        prim_ind = key % self.n_buckets
        if self.prim_arr[prim_ind] is not None:
            sec_ind = key // self.n_bucketitems
            return self.prim_arr[prim_ind][sec_ind]
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)