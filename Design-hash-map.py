#   Time Complexity : O(1)
#   Space Complexity : O(N)
#   Did this code successfully run on Leetcode : Yes
#   Any problem you faced while coding this : No

class ChainArray:
    
    def __init__(self):
        self.chain_array = []
    
    def get(self, key):
        for (k,v) in self.chain_array:
            if k == key:
                return v
        return -1
    
    def update(self, key, value):
        is_present = False
        for i, key_value in enumerate(self.chain_array):
            if key == key_value[0]:
                self.chain_array[i] = (key, value)
                is_present = True
                break
        if not is_present:
            self.chain_array.append((key, value))
    
    def remove(self, key):
        for i, key_value in enumerate(self.chain_array):
            if key == key_value[0]:
                del self.chain_array[i]
        
class MyHashMap(object):

    def __init__(self):
        self.mod = 1229
        self.table = [ChainArray() for i in range(self.mod)]        

    def put(self, key, value):
        hash_key = key % self.mod
        self.table[hash_key].update(key, value)
        

    def get(self, key):
        hash_key = key % self.mod
        return self.table[hash_key].get(key)

    def remove(self, key):
        hash_key = key % self.mod
        self.table[hash_key].remove(key)
