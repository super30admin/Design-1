# Time Complexity : put() - O(1), get() - O(1) 
# Space Complexity : O(m^2) - m=bucketsize
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
I did the problem using double hashing similar to hasset, except for the fact that this required to explicity store key-value
pairs as tuple.
'''

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket_size = 1000
        self.bucketItem_size = 1000 + 1
        self.buckets = [None] * self.bucket_size
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashed_key = key % self.bucket_size
        hashedItem_key = int(key // self.bucketItem_size)
        
        if self.buckets[hashed_key] is None:
            self.buckets[hashed_key] = [(None,None)] * self.bucketItem_size
            
        self.buckets[hashed_key][hashedItem_key] = (key, value)
            
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashed_key = key % self.bucket_size
        hashedItem_key = int(key // self.bucketItem_size)
        
        if self.buckets[hashed_key] is not None:
            k,v = self.buckets[hashed_key][hashedItem_key]
            if k is not None and v is not None:
                return v
                         
        return -1
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashed_key = key % self.bucket_size
        hashedItem_key = int(key // self.bucketItem_size)
        if self.buckets[hashed_key] is not None:
            self.buckets[hashed_key][hashedItem_key] = (None, None)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)