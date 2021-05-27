class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo = 1000
        self.map = [-1]*self.modulo
        self.mapitems = [-1]
        
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
        if self.map[index] == -1:
            if index == 0:
                self.map[index] = self.mapitems*(self.modulo + 1)
            else:
                self.map[index] = self.mapitems*self.modulo
        self.map[index][nested_index] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] is not -1: 
            
            return self.map[index][nested_index]
        
        else:
            return -1
        
        


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self.hash(key)
        nested_index = self.hash_nest(key)
        if self.map[index] is -1:
            return
        self.map[index][nested_index] = -1
      


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)