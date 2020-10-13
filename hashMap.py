
# The hash map is designed by using nesteed list for collision handling.
# Suppose if the same key exist or there  is hash collision, then I append the values to nested list with same key.
# In this approach I have used hash with chaining. The function used to generate hash key is key modulo length or size of array.
# Time Complexity of operations: get hash key - O(1) ,  get list - O(1) , put O(1) , get and remove O(n).
# Space Complexity : O(n^2) for due to nesting (Worst case)
# Any problem you faced while coding this : No 
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashList = [[] for i in range(100)]
    
    def getHashKey(self,key):
        if (str(key).isdigit()):
            return len(self.hashList)%key
        else:
            sumKey = 0
            for character in key:
                sumKey = sumKey + ord(character)
            return sumKey%len(self.hashList)
    
    def getList(self,key):
        return self.hashList[key]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        insertKey = self.getHashKey(key)
        print("Inserting into the data structure")
        self.hashList[insertKey].append(Node(key,value))
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        keyl = self.getHashKey(key)
        flag = 0
        keyList = self.getList(keyl)
        for elem in keyList:
            if (elem.key==key):
                print("Value for the given key:",elem.value)
                flag = 1
                return elem.value
        if (flag==0):
            print("Key not found in the HashMap")
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        keyl = self.getHashKey(key)
        ll = self.getList(keyl)
        flag = 0
        for elem in ll:
            if elem.key == key:
                elem.value = None
                flag = 1
        if flag == 0:
            print("Non-existant element")

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(5,10)
obj.put(10,10)
obj.put(15,10)
val = obj.get(5)
obj.remove(5)