class MyHashMap(object):
    
    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    def __init__(self):
        self.hashMap = {}

    # Insert the key value 
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        self.hashMap[key] = value
        
    # Check the key if present and return the value else return -1
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.hashMap:
            return self.hashMap[key]
        else:
            return -1
        
    # Check the key if present and del it
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if key in self.hashMap:
            del self.hashMap[key]