# Design Hashmap
class MyHashMap:

    def __init__(self):
        self.d = {}

    def put(self, key: int, value: int) -> None:
        self.d[key] = value
        

    def get(self, key: int) -> int:
        # Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        return -1 if key not in self.d else self.d[key]
        

    def remove(self, key: int) -> None:
        #         Removes the mapping of the specified value key if this map contains a mapping for the key

        if key in self.d:
            self.d.pop(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)