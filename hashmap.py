class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # decide a hashfunction and hashmap will be an array of List
        # used a commonly used value as hashvalue (prime number)
        self.hashvalue = 2069
        self.hashmap = [[] for i in range(0,self.hashvalue)]
        self.hashfunction = lambda x: x % self.hashvalue
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative. (O)
        """
        hashList = self.hashmap[self.hashfunction(key)]
        update = 0
        for i in range(0,len(hashList)):
            if(hashList[i][0] == key):
                hashList[i][1] = value
                update = 1
                break
        if(update == 0):
            hashList.append([key,value])

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashList = self.hashmap[self.hashfunction(key)]
        for k,v in hashList:
            if(k == key):
                return v
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashList = self.hashmap[self.hashfunction(key)]
        print(hashList)
        index = -1
        val = -1
        for i in range(0, len(hashList)):
            if(hashList[i][0] == key):
                index = i
                val = hashList[i][1]
                break
        
        if(index != -1):
            hashList.remove([key, val])


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)