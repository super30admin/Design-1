class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.nestedSize = 1000
        self.arr = [None for _ in range(self.size)]
        # print(self.arr)

    def create_nestedarr(self, hashval):
        if hashval == 0:
            return [None for _ in range(self.nestedSize +1)]
        else:
            return [None for _ in range(self.nestedSize)]
        
    def get_hashvalue(self, key):
        return key%self.size
    
    def get_nested_hashvalue(self, key):
        return key//self.nestedSize

    
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashval = self.get_hashvalue(key)
        nestedhashval = self.get_nested_hashvalue(key)
        if self.arr[hashval] == None:
            self.arr[hashval] = self.create_nestedarr(hashval)
        # if self.arr[hashval][nestedhashval] == None:
        self.arr[hashval][nestedhashval] = (key, value)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashval = self.get_hashvalue(key)
        nestedhashval = self.get_nested_hashvalue(key)
        hash_bucket = self.arr[hashval]
        if hash_bucket == None:
            # print("No Elements")
            return -1
        elif self.arr[hashval][nestedhashval] is not None and self.arr[hashval][nestedhashval][0] == key:
            return self.arr[hashval][nestedhashval][1]
        else:
            # print("None")
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashval = self.get_hashvalue(key)
        nestedhashval = self.get_nested_hashvalue(key)
        hash_bucket = self.arr[hashval]
        if hash_bucket != None and self.arr[hashval][nestedhashval] is not None:
            self.arr[hashval][nestedhashval] = None
# this code gives O(1) time complexity and it was submitted in leetcode as well.
