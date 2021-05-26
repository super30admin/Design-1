# Time Complexity : put -> O(1) get -> o(1) remove -> O(1)
# Space Complexity : O(n) n is number of operations
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [None]*1000
        
    def bucket(self,key: int) -> int:
        return key % 1000
    

    def bucketValue(self,key: int) -> int:
        return key//1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        a = self.bucket(key)
        b = self.bucketValue(key)
        if self.arr[a] == None:
            if a == 0:
                self.arr[a] = [None]*1001
            else:
                self.arr[a] = [None]*1000
        self.arr[a][b] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        a = self.bucket(key)
        b = self.bucketValue(key)
        if self.arr[a] == None:
            return;
        return self.arr[a][b]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        a = self.bucket(key)
        b = self.bucketValue(key)
        if self.arr[a] == None:
            return;
        self.arr[a][b] = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)