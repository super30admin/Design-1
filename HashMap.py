import math
class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None for x in range(1000)]
        
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        ##Complexity of put is O(1)
        if(self.arr[key%1000]==None):
            self.arr[key%1000]=[None for x in range(1000)]
        self.arr[key%1000][key//1000]=value
        
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        ##Complexity of put is O(1)
        if self.arr[key%1000]!= None:
            if self.arr[key%1000][key//1000]!=None:
                return self.arr[key%1000][key//1000]
            else:
                return -1
        else:
            return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        ##Complexity of put is O(1)
        if self.arr[key%1000]:
            if self.arr[key%1000][key//1000]!=None:
                self.arr[key%1000][key//1000]=None
        
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
