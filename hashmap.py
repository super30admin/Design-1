# 1. Design Hash Map - Leetcode - 706

#  Time Complexity : O(1) because putting, retrieving is in constant time and no kind of traversal is required.
#  Space Complexity : O(n) because we initialize the list of size n 
#  Did this code successfully run on Leetcode : Only 12 test cases passed out of 36
#  Any problem you faced while coding this : It was difficult to think of the logic for hash function. Referred many online resources and got the idea. 
# IMPORTANT NOTE : 
# One check I could not do or something i assumed is that my hash function will always give me unique value for the keys. Please correct if wrong





class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashNumber = 1000
        self.hashMap = [None] * self.hashNumber
            

    # Writing a hashing function to generate the index
    def hashFunction(self, key):
        return (key % self.hashNumber)
            
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        keyIndex = self.hashFunction(key)
        pair = [key,value]
        if self.hashMap[keyIndex] is None:
            self.hashMap.insert(keyIndex,pair)
        else:
            self.hashMap[keyIndex] = list(pair)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        keyIndex = self.hashFunction(key)
        if self.hashMap[keyIndex] is None:
            return -1
        element = self.hashMap[keyIndex]
        return element[1]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        keyIndex = self.hashFunction(key)
        self.hashMap[keyIndex] = None


        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)