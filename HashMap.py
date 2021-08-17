class MyHashMap:

    def __init__(self):
        self.D = dict()

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.D[key] = value
        return None

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if key in self.D.keys():
            return self.D[key]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        if key in self.D.keys():
            self.D.pop(key)


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1, 2)
obj.put(2, 22)
obj.put(3, 52)
obj.put(4, 26)
print(obj.D)
obj.put(1, 34445465)
param_2 = obj.get(2)
print(param_2)
obj.remove(2)
print(obj.D)
