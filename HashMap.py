#  Time Complexity :
#  Space Complexity :
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
#  Your code here along with comments explaining your approach

class MyHashMap:
    def __init__(self):
        """Initialize your data structure here."""
        self.hashmap = {}

    def put(self, key: int, value: int):
        """value will always be non-negative."""
        return None

    def get(self, key: int) :
        """Returns the value to which the specified key is mapped, or -1 if
        this map contains no mapping for the key."""
        keys_list = [keys for keys in self.hashmap]
        if key in keys_list:
            return self.hashmap[key]
    

    def remove(self, key: int) :
        """Removes the mapping of the specified value key if this map contains
        a mapping for the key."""
        self.hashmap.pop(key, -1)
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.hashmap.pop(key, -1)


hashMap = MyHashMap()
hashMap.put(1, 2)
hashMap.put(2, 3)         
hashMap.get(1)
hashMap.get(3)
hashMap.put(2, 4)
hashMap.get(2)
hashMap.remove(2)
hashMap.get(2)
