#Time Complexity : The computational time for implementing hashmap using array in Python is O(1). Runtime: 396 ms 
# Space Complexity : Memory Usage: 37.8 MB
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initally yes, as I didn't remember HashMap.
# Your code here along with comments explaining your approach
# Approach
"""
 Used array to implement Hashmap. Array is initialized with size as given in problem
 for insertion the current instance of class will insert value and the value is returned using get if specified key is mapped
 for removing element mapping of the specified value key if this map contains a mapping for the key   
"""

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=1000000      
        self.map=[-1] * self.size
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        self.map[key]=value

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        return self.map[key]

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        self.map[key]=-1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)