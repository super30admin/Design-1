# Time Complexity: everything O(1)
# Space Complexity: O(n)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this: None

# Approach: Double Hashing
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self._p_bkt_size = 1000
        self._s_bkt_size = 1001
        self._hash_map = [None] * self._p_bkt_size


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        p_bkt = self._p_bkt(key)
        s_bkt = self._s_bkt(key)
        if self._hash_map[p_bkt] is None:
            self._init_s_bkt(p_bkt)
        self._hash_map[p_bkt][s_bkt] = value


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        p_bkt = self._p_bkt(key)
        s_bkt = self._s_bkt(key)
        if self._hash_map[p_bkt] is None or self._hash_map[p_bkt][s_bkt] is None:
            return -1

        return self._hash_map[p_bkt][s_bkt]


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        p_bkt = self._p_bkt(key)
        s_bkt = self._s_bkt(key)
        if self._hash_map[p_bkt] is None:
            return

        self._hash_map[p_bkt][s_bkt] = None


    def _p_bkt(self, key):
        return key % self._p_bkt_size


    def _s_bkt(self, key):
        return key // self._s_bkt_size


    def _init_s_bkt(self, p_bkt):
        self._hash_map[p_bkt] = [None] * self._s_bkt_size



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
