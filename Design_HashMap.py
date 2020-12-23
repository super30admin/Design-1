#using single hashing technique to create hashmap datastructure
#defining class with put, get and remove functions
class Bucket: 
    
    def __init__(self):
        """
        bucket holds tuple values of key and value pair
        """
        self.bucket = [] 
        
    
    def put(self, key: int, val: int):
        
        """
        check if the key already exists in bucket
        """
        for i, keyVal in enumerate(self.bucket): 
            if keyVal[0] == key:
                self.bucket[i] = (key, val)
                return

        self.bucket.append((key, val))
        
    
    
    def get(self, key: int):
        
        """
        check if the bucket holds the key. if yes return the value else return -1
        """
        for keyVal in self.bucket: 
            
            if keyVal[0] == key:
                
                return keyVal[1]

        return -1
    
    
    def remove(self, key: int):
        
        for i, keyVal in enumerate(self.bucket): 
            
            if keyVal[0] == key:
                
                del self.bucket[i]
                
                
                
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.size = ceil(sqrt(1000000))
        self.hash_map = [Bucket() for i in range(self.size)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_key = key % self.size
        self.hash_map[hash_key].put(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_key = key % self.size
        return self.hash_map[hash_key].get(key)
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_key = key % self.size
        self.hash_map[hash_key].remove(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
