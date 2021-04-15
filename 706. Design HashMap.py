'''
T = O(1)
S = O(1)

Approach:
Maintain a matrix of length 1000 * 1000
calculate the index based on the key value and store the correspoing value
'''
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.aMap = [[None for _ in range(1001)]for _ in range(1001)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        idx1,idx2 = self.HashIndex(key)
        self.aMap[idx1][idx2] = value
            
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx1,idx2 = self.HashIndex(key)
        if self.aMap[idx1][idx2] != None:
            return self.aMap[idx1][idx2]
        else:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx1,idx2 = self.HashIndex(key)
        self.aMap[idx1][idx2] = None
        
    def HashIndex(self,key):
        idx1 = key % 1000
        idx2 = key // 1000
        return idx1,idx2
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)