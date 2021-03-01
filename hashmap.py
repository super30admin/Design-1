class MyHashMap(object):

    def __init__(self):

        self.capacity = 10000
        self.hash_table = [None]*self.capacity
        for i in range (0,self.capacity):
            self.hash_table[i] = {}
        
        """
        Initialize your data structure here.
        """
    def my_hash(self,key):
        index = key % self.capacity
        return index   

    def put(self, key, value):
        index = self.my_hash(key)
        self.hash_table[index][key] = value 
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
    def get(self, key):
        index = self.my_hash(key)
        if self.hash_table[index].has_key(key):
            return self.hash_table[index][key]
        else:
            return -1
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        

    def remove(self, key):
        index = self.my_hash(key)
        if self.hash_table[index].has_key(key):
            del self.hash_table[index][key]
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
