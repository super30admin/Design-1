
# // Time Complexity : O(N/K) 
# // Space Complexity :O(K+M)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# we take a bucket array for each index postion
# we hash the key using prime number so that there will be very less collisions
# Each value will be inserted in the bucket respective to the hash
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_size = 2069
        self.hashmap = [Bucket() for i in range(self.key_size)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_key = key % self.key_size
        self.hashmap[hash_key].update(key,value)
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_key = key % self.key_size
        return self.hashmap[hash_key].get(key)
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        

class Bucket:
    def __init__(self):
        self.bucket = []
    
    def update(self,key,value):
        found = False
        for i,kv in enumerate(self.bucket):
            if key == kv[0]:
                found = True
                self.bucket[i] = (key,value)
                break
        if not found:
            self.bucket.append((key,value))
    
    def remove(self,key):
        for i,kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[key]
    def get(self,key):
        for (k,v) in self.bucket:
            if k == key:
                return v
        return -1


obj = MyHashMap()
obj.put(1,1)
param_2 = obj.get(1)
print(param_2)
obj.remove(1)