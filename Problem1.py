class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = [None] * 100000
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        # can use mod here as the key, e.g: self.bucket[key%mod] = value
        self.bucket[key] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if self.bucket[key] != None:
            return self.bucket[key]
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.bucket[key] = None

obj = MyHashMap()
obj.put(1,1)
obj.put(2,2)
print(obj.get(1))
print(obj.get(3))
obj.put(2,1)
print(obj.get(2))
obj.remove(2)
print(obj.get(2))