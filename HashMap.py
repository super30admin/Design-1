class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map=[-1]*100000


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_key= key%len(self.map)
        self.map[hash_key]=value


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_key= key%len(self.map)
        return self.map[hash_key]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_key= key%len(self.map)
        self.map[hash_key]=-1


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1, 100)
obj.put(2, 200)
obj.put(3, 300)
param_2 = obj.get(2)
print(param_2)
obj.remove(3)