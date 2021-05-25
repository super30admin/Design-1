class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 100
        self.arr = [[] for _ in range(self.size)]
        
    def get_hashvalue(self, key):
        hashvalue = 0
        for char in str(key):
            hashvalue += ord(char)
        return hashvalue%self.size
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashval = self.get_hashvalue(key)
        hash_bucket = self.arr[hashval]
        key_found = False
        for index, element in enumerate(hash_bucket):
            if key == element[0]:
                key_found = True
                hash_bucket[index] = (key, value)
        if not key_found:
            hash_bucket.append((key, value))
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashval = self.get_hashvalue(key)
        hash_bucket = self.arr[hashval]
        key_found = False
        for index, element in enumerate(hash_bucket):
            if key == element[0]:
                key_found = True
                return element[1]
        if not key_found:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashval = self.get_hashvalue(key)
        hash_bucket = self.arr[hashval]
        key_found = False
        for index, element in enumerate(hash_bucket):
            if key == element[0]:
                key_found = True
                hash_bucket.pop(index)
        return 
                
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)