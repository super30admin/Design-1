# Time Complexity : Ammortized - O(1) 
# Space Complexity : O(n), where n is the size of stack
# Did this code successfully run on Leetcode : Yes , LC 705
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
        indx = key % self.arr_size
        if key not in self.arr[indx]:
            self.arr[indx].append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        indx = key % self.arr_size
        if key in self.arr[indx]:
            self.arr[indx].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        indx = key % self.arr_size
        if key in self.arr[indx]:
            return True
        return False