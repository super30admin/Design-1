class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo = 1000
        self.map = [None]*self.modulo
        self.mapitems = [None]
        
    def hash(self,key):
        return key%self.modulo
    
    def hash_nest(self,key):
        return key//self.modulo

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] == None:
            self.map[index] = self.mapitems*self.modulo
        self.map[index][nested_index] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] == None: 
            return -1
        
        return self.map[index][nested_index]


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] is None:
            return
        self.map[index][nested_index] = None
      


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)