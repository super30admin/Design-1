# Time Complexity : O(N/K) where N is all possible keys and K is the predefined number of buckets. K is chosen in such a way that it obeys max size requirement of the question and helps reduce collisions. Hence a prime number above required size limit is chosen. In this case I have used 2069

# Space Complexity : O(K+M) where K is predefined number of buckets and M is number of unique keys entered in to the hashMap. 

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : I have tried this one earlier by understanding leetcode's solution. Using the same as standard. This is my first question, should I refer to standard solutions to understand if I am stuck going forward?

# Code: 
# Array- Modulo method. I will be using array as buckets and modulo operation for hashing function
# We define bucket which will be used for chaining machanism in case of collisions. Collision: when multiple keys when share same index of the memory location.
class Bucket:
    def __init__(self):
        self.bucket = []
    # If key matches with existing ones, return value or return -1
    def get(self, key):
        for (k,v) in self.bucket:
            if k == key:
                return v
        return -1
    # First, check if key exists- if yes update key, value pair else append the bucket with new key, value(collision)
    def update(self, key, value):
        found = False
        for i, kv in enumerate(self.bucket):    
            if key == kv[0]:
                self.bucket[i] = (key, value)
                found = True
                break
        if not found:
            self.bucket.append((key, value))
    # Search by key, use python list's del operation to delete element(key-value)
    def remove(self, key):
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]

# HashMap implementation
class MyHashMap(object):
    def __init__(self):
        # A prime number above required max size limit is chosen to avoid collisions 
        self.modulo = 2069
        # build modulo number of buckets
        self.hashTable = [Bucket() for i in range(self.modulo)]
    
    def put(self, key, value):
        # hash function : using standard modulo operation to generate memory index where required operation will take place
        hashKey = key % self.modulo
        self.hashTable[hashKey].update(key,value)
    
    def get(self, key):
        hashKey = key % self.modulo
        return self.hashTable[hashKey].get(key)
        
    def remove(self, key):
        hashKey = key % self.modulo
        self.hashTable[hashKey].remove(key)

hashMap = MyHashMap()
hashMap.put(1, 2)          
hashMap.put(2, 3)         
getOutput1 = hashMap.get(1)            # returns 2
getOutput2 = hashMap.get(3)            # returns -1 (not found)
hashMap.put(2, 4)         # update the existing value
getOutput3 = hashMap.get(2)            # returns 4 
hashMap.remove(2)         # remove the mapping for 2
getOutput4 = hashMap.get(2)            # returns -1 (not found)

print(getOutput1, getOutput2, getOutput3, getOutput4)
