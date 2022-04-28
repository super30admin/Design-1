// Time Complexity : O(1)
// Space Complexity : S(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding : None

class MyHashMap(object):

    def __init__(self):
        self.hash = {}

    def put(self, key, value):
        self.hash[key] = value

        """
        :type key: int
        :type value: int
        :rtype: None
        """

    def get(self, key):
        return self.hash.get(key, -1)
        """
        :type key: int
        :rtype: int
        """

    def remove(self, key):
        self.hash.pop(key, None)
        """
        :type key: int
        :rtype: None
        """

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)