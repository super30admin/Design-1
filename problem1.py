# # Design Hashmap
# 706. Design HashMap
# Design a HashMap without using any built-in hash table libraries.

# To be specific, your design should include these functions:

# put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
# get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
# remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

# Example:

# MyHashMap hashMap = new MyHashMap();
# hashMap.put(1, 1);          
# hashMap.put(2, 2);         
# hashMap.get(1);            // returns 1
# hashMap.get(3);            // returns -1 (not found)
# hashMap.put(2, 1);          // update the existing value
# hashMap.get(2);            // returns 1 
# hashMap.remove(2);          // remove the mapping for 2
# hashMap.get(2);            // returns -1 (not found) 

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.res = {}

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.res[key]= value
        print("HashMap current key:value :", self.res) 

        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if key in self.res:
            return self.res[key]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        if key in self.res:
            del self.res[key]
        print("HashMap current key:value :", self.res)

hashMap = MyHashMap()
hashMap.put(1, 1)
hashMap.put(2, 2)
print(hashMap.get(1))
print(hashMap.get(3))
hashMap.put(2, 1)
print(hashMap.get(2))
hashMap.remove(2)
print(hashMap.get(2))