"""
Time Complexity: O(1)
Space Complexity: O(n)
Did this code run successfully on leetcode: Yes

Problem:
Implement a HashMap without any built-in libraries.

Your implementation should include these three functions: 
put(key, value) : Insert a (key, value) pair into the HashMap or If the value already exists, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if  no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 2);          
hashMap.put(2, 3);         
hashMap.get(1);             // returns 2
hashMap.get(3);             // returns -1 (not found)
hashMap.put(2, 4);          // update the existing value
hashMap.get(2);             // returns 4 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);             // returns -1 (not found)
"""

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashMap = [None] * (1000000+1)
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.hashMap[key] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        if self.hashMap[key] == None:
            return -1
        else:
            return self.hashMap[key]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        if self.hashMap[key] != None:
            self.hashMap[key] = None


# Testing
            
hashMap = MyHashMap()
hashMap.put(1, 2)          
hashMap.put(2, 3)       
print(hashMap.get(1))              # returns 2
print(hashMap.get(3))              # returns -1 (not found)
hashMap.put(2, 4)                  # update the existing value
print(hashMap.get(2))              # returns 4 
hashMap.remove(2)                  # remove the mapping for 2
print(hashMap.get(2))              # returns -1 (not found)
