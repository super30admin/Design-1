# Time Complexity: O(1)
# Space Complexity: O(n)

class Bucket:
    def __init__(self):
        self.bucket = []
        
    def get(self, key):
        for (k,v) in self.bucket:
            if k == key:
                return v        
        return -1
    
    def update(self, key, value):
        found = False
        for i, kv_tuple in enumerate(self.bucket):
            if kv_tuple[0] == key:
                
                self.bucket[i] = (key, value)
                found = True
                break
        
        if not found:
            self.bucket.append( (key, value) )
    
    def remove(self, key):
        # Don't use range() bcz len changes when del
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.modulo_base = 2069 #prime no. better
        self.hash_table = [Bucket() for i in range(self.modulo_base)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashkey = key % self.modulo_base
        self.hash_table[hashkey].update(key, value)
        
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashkey = key % self.modulo_base
        return self.hash_table[hashkey].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashkey = key  % self.modulo_base
        self.hash_table[hashkey].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)