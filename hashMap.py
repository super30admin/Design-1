class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1001
        self.bucketItems = 1000
        self.storage = [None for i in range(self.buckets)]
        
    def hash1(self,key):
        return int(key%1000)
        
    def hash2(self,key):
        return int(key/1000)

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        indx1 = self.hash1(key)
        indx2 = self.hash2(key)
        #print(indx1,indx2)
        if not self.storage[indx1]:
            self.storage[indx1] = [-1 for i in range(self.bucketItems)]
        self.storage[indx1][indx2] = value
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        indx1 = self.hash1(key)
        indx2 = self.hash2(key)
        if not self.storage[indx1]:
            return -1
        else:
            return self.storage[indx1][indx2]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        indx1 = self.hash1(key)
        indx2 = self.hash2(key)
        if not self.storage[indx1]:
            return
        self.storage[indx1][indx2] = -1
        

#TC: for all abstract functions we have O(1)
#SC: Assign 1001 memory locations initially for the keys and 
# later as each key comes in assign the next 1000 positions at every hash location to save space
# so time complexity is O(range of hasmap)

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)