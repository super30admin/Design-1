# Time Complexity: O(1)
#  Space Complexity : O(n)

#  Defined a extra data structure to avoid collision
class Chain:

    def __init__(self):
        self.chain = [-1] * (10000000 - 1)

    def get(self, key):
        for i in range(len(self.chain)):
            if key == i:
                return self.chain[i]
        return -1

    def update(self, key, val):
        ele_found = 0

        for i in range(len(self.chain)):
            if key == i:
                self.chain[i] = val
                ele_found = 1
                break
        if ele_found == 0:
            self.chain[key] = val

    def remove(self, key):

        for i in range(len(self.chain)):
            if key == i:
                del self.chain[i]


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # defining the key space as prime number so that we can try to avoid collision for same hashcode
        self.space = 2069
        self.hashtable = [Chain()] * self.space

    def put(self, key, value):
        # create hash key by using key space
        # and add the key value pair at that location in designed hashtable
        current_hash_key = key % self.space
        self.hashtable[current_hash_key].update(key, value)
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """

    def get(self, key):
        current_hash_key = key % self.space
        return self.hashtable[current_hash_key].get(key)

        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """

    def remove(self, key):
        current_hash_key = key % self.space
        self.hashtable[current_hash_key].remove(key)

        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)