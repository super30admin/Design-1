#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No
#Time complexity : O(1)


class Bucket:
    def __init__(self):
        self.bucket = []

    def get(self,key):
        for item in self.bucket:
            if item[0]==key:
                return item[1]
        return -1

    def update(self,key,value):
        found =  False
        for index,item in enumerate(self.bucket):
            if item[0]==key:
                self.bucket[index] = (key,value)
                found = True
                break
        if not found:
            self.bucket.append((key,value))


    def remove(self, key):
        for index, item in enumerate(self.bucket):
            if key == item[0]:
                del self.bucket[index]


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # better to be a prime number, less collision
        self.key_space = 2069
        self.hash_table = [Bucket() for i in range(self.key_space)]


    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hash_key = key % self.key_space
        self.hash_table[hash_key].update(key, value)


    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hash_key = key % self.key_space
        return self.hash_table[hash_key].get(key)


    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hash_key = key % self.key_space
        self.hash_table[hash_key].remove(key)

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(2,2)
param_2 = obj.get(2)
obj.remove(2)