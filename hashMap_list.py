
## Time Complexity : O(n) for put, get, remove
## Space Complexity : O(n)
## Did this code successfully run on Leetcode : Yes

## Any problem you faced while coding this :

# Here I have used a very simple approach to build hashmap using two list. Its not optimized as
# each function takes O(n) time to execute. The optimized version can be found in hashMap.py


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.keys = []
        self.values = [] 

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        if key in self.keys:
            for i,stored_key in enumerate(self.keys):
                if stored_key == key:
                    self.values[i] = value
                    break
        else:
            self.keys.append(key)
            self.values.append(value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        for i,stored_key in enumerate(self.keys):
            if stored_key == key:
                return self.values[i]
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        
        for i,stored_key in enumerate(self.keys):
            if stored_key == key:
                value = self.values[i]
                self.keys[i] = -1
                self.values[i] = -1
                break
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)