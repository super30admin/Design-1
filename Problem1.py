"""
// Time Complexity : o(n), where n is the number of key-value pairs
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

# Your code here along with comments explaining your approach

class MyHashMap(object): #implementing hashmap using a python list

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.hashmap=[]
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """ # storing key-value pairs as tples in the list
        for k,v in self.hashmap: #checking if the pair already exists
            if k==key:
                self.hashmap.remove((k,v)) #if it exists, remove the tuple and get out of the loop
                break
        self.hashmap.append((key,value)) #appned the new key-value pair

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        for k,v in self.hashmap: #checking for key in the hashmap
            if k==key:
                return v #if exists, return the value
        return -1 #else return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        for k,v in self.hashmap: #checking for key in the hashmap
            if k==key:
                self.hashmap.remove((k,v)) #if exists, remove
                break
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
