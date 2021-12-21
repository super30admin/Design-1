# Time Complexity : O(1) for put, get, remove
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach : Took a byte array to increase the efficiency and stored the boolean values for the value existance

class MyHashSet(object):
    
    def __init__(self):
        self.hashset = bytearray(1000001)

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        if not self.hashset[key]:
            self.hashset[key] = 1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if self.hashset[key]:
            self.hashset[key] = 0

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        return self.hashset[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)