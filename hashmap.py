class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo = 1000
        self.map = [None]*self.modulo
        
    def hash(self,key):
        return key%self.modulo

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.hash(key)
        self.map[index] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.hash(key)
        if self.map[index] is not None:
            return self.map[index]
        
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.hash(key)
        if self.map[index] is None:
            return
        self.map[index] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)