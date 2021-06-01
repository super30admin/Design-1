# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 10000000 - 1
        self.bucketitems = 1001
        self.storage = [None] * self.buckets

    def get_bucket(self, key):
        return key % self.buckets

    def get_bucketitems(self, key):
        return key // self.bucketitems

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        bucket = self.get_bucket(key)
        bucketitem = self.get_bucketitems(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = [None] * self.bucketitems
        self.storage[bucket][bucketitem] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        bucket = self.get_bucket(key)
        bucketitem = self.get_bucketitems(key)
        if self.storage[bucket] == None:
            return -1
        return self.storage[bucket][bucketitem]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucket = self.get_bucket(key)
        bucketitem = self.get_bucketitems(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketitem] = -1

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)