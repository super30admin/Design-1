'''
I have used the chaining method as the hashing strategy.
I used modulo operator as the hashing function and used Array as the Bucket DS
I have used a prime number as the keyRange since it makes the collision strategy more stronger.
The bucket is an array which holds a key-value pair which should be stored in HashMap
'''

class Bucket:
    def __init__(self):
        self.bucket = []

    def get(self, key):
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1

    def update(self, key, value):
        flag = False  #flag which check if the key already exists or not
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                self.bucket[i] = (key, value)
                flag = True
                break

        if not flag:
            self.bucket.append((key, value))

    def remove(self, key):
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]

class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.keyRange = 2069
        self.hashTable = [Bucket() for i in range(self.keyRange)]
    def getHashKey(self, key):
        hashKey = key % self.keyRange
        return hashKey

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        self.hashTable[self.getHashKey(key)].update(key, value)

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        return self.hashTable[self.getHashKey(key)].get(key)

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        self.hashTable[self.getHashKey(key)].remove(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)