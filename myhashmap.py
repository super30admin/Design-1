# Time Complexity : O(N/K) where K is the number of buckets (here 2069) and n is the number of all possible keys
# Space Complexity : O(M + K) where K is the number of buckets (here 2069) and M is the number of keys
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The bucket implementation for each key 
# as well as the time complexity was a little tricky to understand.


class Bucket:
    def __init__(self):
        self.bucket = []
    
    def get(self, key):
        # each bucket element is a [key, value] pair
        for (k, v) in self.bucket:
            if k == key:
                return v 
        return -1
    
    def update(self, key, value):
        found = False
        # k is a list of the form [key, value] so  k[0] is the key
        for (i, k) in enumerate(self.bucket):
            if k[0] == key:
                self.bucket[i] = (key, value)
                found = True
                break
        
        if not found:
            self.bucket.append((key, value))
                    
    def remove(self, key):
        # v is a list of the form [key, value] so  v[0] is the key
        for (i, v) in enumerate(self.bucket):
            if v[0] == key:
                del self.bucket[i]

    def printBucket(self):
        for (i, v) in enumerate(self.bucket):
            print('Key: '+str(v[0]) + ' - '+'Value: '+str(v[1]))



class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_space = 2069
        self.hash_map = [Bucket() for i in range(self.key_space)]
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_key = key % self.key_space
        self.hash_map[hash_key].update(key, value)
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_key = key % self.key_space
        return self.hash_map[hash_key].get(key)
        
    
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_key = key % self.key_space
        self.hash_map[hash_key].remove(key)

    def printmap(self):
        for bucket in range(len(self.hash_map)):
            self.hash_map[bucket].printBucket()



        
obj = MyHashMap()
key = 1
value = 1
obj.printmap()
obj.put(key,value)
obj.put(2,2)
obj.put(3,3)
obj.put(4,4)

print()
obj.printmap()
param_2 = obj.get(key)

obj.remove(key)
print('\nAfter removal of key: '+str(key)+'\n')
obj.printmap()
print()