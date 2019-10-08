class MyHashMap:
    def __init__(self):
        self.hash_map= {}
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.hash_map[key]=value
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if key in self.hash_map:
            return self.hash_map[key]
        else:
            return None
    def remove(self, key: int) -> None:
        if key in self.hash_map:
            self.hash_map.pop(key)
        else:
            return None
"""
         Removes the mapping of the specified value key if this map contains a mapping for the key
        """



# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,4)
print(obj.get(1))
obj.remove(1)
print(obj.get(1))
