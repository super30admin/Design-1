#  Time Complexity :O(1)
#  Space Complexity :O(1)
#  Did this code successfully run on Leetcode :
#  No
#  Any problem you faced while coding this :
# Trying to understand the error.


#  Your code here along with comments explaining your approach


class MyHashSet(object):

    def __init__(self):
        self.hashset = []

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key not in self.hashset:
            self.hashset.append(key)

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hashset.pop()
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        if key in self.hashset:
            return True
        else:
            False

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)