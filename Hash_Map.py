class Map:
    def __init__(self):
        self.bucket = []

    def get(self, key):
        #Time Complexity -> O(N)
        for stored_key,value in self.bucket:
            if key == stored_key:
                return value
        return -1
    def update(self, key,value):
        #Time Complexity -> O(N)
        for index,key_val_pair in enumerate(self.bucket):
            if key == key_val_pair[0]:
                self.bucket[index] = (key,value)
                return
        self.bucket.append((key,value))
    
    def remove(self, key):
        #time Complexity -> O(N)
        for index,key_val_pair in enumerate(self.bucket):
            if key == key_val_pair[0]:
                del self.bucket[index]
                
    
    
class MyHashMap:

    def __init__(self):
        """
        We use a list to store key value pair for same hash key values.
        Initialized the hash map size for a prime number
        """
        #Total no of keys: "N", "K" is the size of array containing 9973 buckets
        self.key_width = 9973
        self.hash_table = [Map() for i in range(self.key_width)]
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        Time Complexity: O(N/K)
        """
        key_position = key%self.key_width
        self.hash_table[key_position].update(key,value)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        Time Complexity: O(N/K)
        """
        key_position = key%self.key_width
        return self.hash_table[key_position].get(key)
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        Time Complexity: O(N/K)
        """
        key_position = key%self.key_width
        self.hash_table[key_position].remove(key)
        
#Space_Complexity is O(K + M) (K is no of buckets, M is Unique keys inserted)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)