#Reference Video: https://youtu.be/w9JhOKb4tyk
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        #size of primary array
        self.size = 1000
        self.array = [[] for i in range(self.size)]
    
    #function to calculate hash value
    def calHash(self, key):
        return key % self.size
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        #calculate hash value using hashing function
        hash_value = self.calHash(key)
        #bucket has the array at the index hash_value 
        bucket = self.array[hash_value]
        found = False 
        for i in range(len(bucket)):
            if bucket[i][0] == key:
                bucket[i][1] = value
                found = True
        if not found:
            bucket.append([key,value])
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_value = self.calHash(key)
        bucket = self.array[hash_value]
        for hash_value,val in bucket:
            if hash_value == key:
                return val
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_value = self.calHash(key)
        bucket = self.array[hash_value]
        for i in range(len(bucket)):
            if bucket[i][0] == key:
                del bucket[i]
                break
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)