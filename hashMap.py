"""
Intuition: In this program, a hashmap is implemented using a dictionary.

#####################################################################
Put Method: Inserting a value at a key if the key is present. The vlaue will be overwritten if the key is not present.
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Get Method: Accessing the value at a particular key.
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Remove Method: The key is removed only if it is present.
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
"""

class MyHashMap:

    def __init__(self):
        self.hashMap = {}

    def put(self, key: int, value: int) -> None:
        #Checking if key is not present
        if key not in self.hashMap:
            self.hashMap[key] = value
        self.hashMap[key] = value

    def get(self, key: int) -> int:
        #Checking if key is not present
        if key not in self.hashMap:
            return -1
        return self.hashMap[key]
        

    def remove(self, key: int) -> None:
        #Removing a key if it is present
        if key in self.hashMap:
            del self.hashMap[key]
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)