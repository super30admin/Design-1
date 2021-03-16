# Time Complexity: O(k) where k is the bucket size
# Space Complexity: O(C + k) where C is the bucker size and k is the size of array of collision elements 
# Ran on leetcode: Yes
# Difficulties: Managing collision 

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000
        self.arr = [[]] * self.size
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashed = key % self.size
        found = False
        if len(self.arr[hashed]):
            for i in range(len(self.arr[hashed])):
                if self.arr[hashed][i][0] == key:
                    self.arr[hashed][i] = [key,value]
                    found = True
                    break
            if not found:
                self.arr[hashed].append([key, value])
        else:
            self.arr[hashed].append([key, value])
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashed = key % self.size
        if len(self.arr[hashed]):
            
            for i in range(len(self.arr[hashed])):
                if self.arr[hashed][i][0] == key:
                    return self.arr[hashed][i][1]
        
        return -1
        
        
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashed = key % self.size
        if len(self.arr[hashed]):
            for i in range(len(self.arr[hashed])):
                if self.arr[hashed][i][0] == key:
                    self.arr[hashed].pop(i)
                    break

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)