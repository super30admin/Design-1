# Time Complexity : O(n/K) (where K is size of hash map) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No
class StoreArr:
    def __init__(self):
        self.arr = []
    
    def assignValue(self,key,value):
        flag = False
        for ind,k in enumerate(self.arr):
            if k[0] == key:
                self.arr[ind] = (key,value) 
                flag = True
                return
        if not flag:
            self.arr.append((key,value))
    
    def exists(self,key):
        for kv in self.arr:
            if kv[0]==key:
                return kv[1]
        return -1
    
    def remove(self,key):
        if self.arr == []:
            return
        else:
            for ind,k in enumerate(self.arr):
                if k[0] == key:
                    del self.arr[ind]

            
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashFun = 1000
        self.storeArr = [StoreArr() for i in range(0,1000)]
    
    def _hash(self,key):
        return key % self.hashFun
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index = self._hash(key)
        self.storeArr[index].assignValue(key,value)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index = self._hash(key)
        return self.storeArr[index].exists(key)
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index = self._hash(key)
        self.storeArr[index].remove(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
