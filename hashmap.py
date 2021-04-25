class Bucket():
    
    def __init__(self,):
        self.bucket = []
        
    def get(self,key):
        
        for (k,v) in self.bucket:
            if key == k:
                return v
            
        return -1
    
    def add(self,key,value):
        
        found = False
        for i,(k,v) in enumerate(self.bucket):
            if k == key:
                self.bucket[i] = (key,value)
                found = True
                
        if found is False:
            self.bucket.append((key,value))
            
    def remove(self,key):
        
        for i, (k,v) in enumerate(self.bucket):
            if k == key:
                del self.bucket[i]
                

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_size = 2069
        self.hash_map = [Bucket() for i in range(self.key_size)]
        
        
    def hash_function(self,key):
        self.hash_value = key % self.key_size
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.hash_function(key)
        return self.hash_map[self.hash_value].add(key,value)
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        self.hash_function(key)
        return self.hash_map[self.hash_value].get(key)
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.hash_function(key)
        return self.hash_map[self.hash_value].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)