# Time Complexity : Amortized - O(1) | Worst Case - O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyHashSet(object):

    def __init__(self):
        self.arr_size = 2069
        self.arr = [[] for _ in range(self.arr_size)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = key % self.arr_size
        if key not in self.arr[idx]:
            self.arr[idx].append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = key % self.arr_size
        if key in self.arr[idx]:
            self.arr[idx].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        idx = key % self.arr_size
        if key in self.arr[idx]:
            return True
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)