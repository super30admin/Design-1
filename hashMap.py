"""
Intuition: In this program, a hashmap is implemented using a lists. 
Double hashing is utilized to handle collisions.

A 2D array has been created to indicate wheather a key is present or not. 
The key is located by computing its hashValue.
If 2 keys have the same hashValue, collision occurs and then we compute another hashvalue to store the key.

Another way to visulize it is:
The 'row' or the 'ith' index of the key is obtainted by getting computing: key % perfectSquare(numberOfElements)
The 'column' or the 'jth' index of the key is obtainted by getting computing: key / perfectSquare(numberOfElements)

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
        self.hashMap = [None] * 1000

    def getPrimaryHashValue(self,key):
        return key % 1000
    
    def getSecondaryHashValue(self, key):
        return key // 1000
        
    def put(self, key: int, value: int) -> None:
        
        hashValue = self.getPrimaryHashValue(key)
        secondaryHashValue = self.getSecondaryHashValue(key)
        
        if self.hashMap[hashValue] == None:
            if hashValue == 0:
                self.hashMap[hashValue] = [None] * 1001
            else:
                self.hashMap[hashValue] = [None] * 1000
        self.hashMap[hashValue][secondaryHashValue] = value
            
    def remove(self, key: int) -> None:

        hashValue = self.getPrimaryHashValue(key)
        secondaryHashValue = self.getSecondaryHashValue(key)
        
        if self.hashMap[hashValue] == None:
            return
        self.hashMap[hashValue][secondaryHashValue] = None
        
    def get(self, key: int) -> int:

        hashValue = self.getPrimaryHashValue(key)
        secondaryHashValue = self.getSecondaryHashValue(key)
        
        if self.hashMap[hashValue] == None:
            return -1
        if self.hashMap[hashValue][secondaryHashValue] == None:
            return -1
        return self.hashMap[hashValue][secondaryHashValue]

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
        
