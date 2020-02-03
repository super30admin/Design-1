// Time Complexity : O(1)
// Space Complexity : o(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficulty in figuring out complexity. I think there is a better solution


// Your code here along with comments explaining your approach


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.itemsinbucket = 1001
        self.hashmap = [None for _ in range(self.buckets)]
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        hash = key%self.buckets
        bucket_hash = key//self.itemsinbucket
        if not self.hashmap[hash]:
            self.hashmap[hash] = [None] *self.itemsinbucket
        
        self.hashmap[hash][bucket_hash] = value
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        hash = key%self.buckets
        bucket_hash = key//self.itemsinbucket
        if not self.hashmap[hash] or self.hashmap[hash][bucket_hash] == None:
            return -1
        return self.hashmap[hash][bucket_hash]
        
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        hash = key%self.buckets
        bucket_hash = key//self.itemsinbucket
        if self.hashmap[hash]!=None :
            self.hashmap[hash][bucket_hash] = None
        


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
print(obj.put(1, 1),obj.put(2, 2),obj.get(1),obj.get(3),obj.put(2, 1),obj.get(2),obj.remove(2),obj.get(2))
