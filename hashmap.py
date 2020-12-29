
// Time Complexity : O(N)
// Space Complexity : O(N + K)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict_  = {}

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        
        if(key in self.dict_):
            self.dict_[key] = value
            
        else:
            self.dict_[key] = value
            
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if(key in self.dict_):
            return self.dict_[key]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        
        if(key in self.dict_):
            del self.dict_[key]
