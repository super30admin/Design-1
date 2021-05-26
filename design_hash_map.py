
class MyHashMap:

    def _init_(self):
        """
        Initialize your data structure here.
        Create list of given size +1
        """
        self.size = 10001
        self.l = [None]*self.size
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        key_hash = key % self.size
        key_value = [key, value]
        if self.l[key_hash] is None:
            self.l[key_hash] = self.l.append(key_value)
        
        for pair in self.l[key_hash]:
            if pair[0]==key:
                pair[1]=value
                self.l[key_hash].append(key_value)
           
        
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        key_hash = key % self.size
        if self.l[key_hash] is not None:
            for pair in self.l[key_hash]:
                if pair[0] == key:
                    return pair[1]
                else:
                    return -1
     
    
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        key_hash = key % self.size
        if self.l[key_hash] is None:
            return 
        for i in range(0, len(self.l[key_hash])):
            if self.l[key_hash][i][0] == key:
                self.l[key_hash].pop(i)
                
        
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)