# // Time Complexity : O(n/k)
# // Space Complexity : O(n+k)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No.But will try double hashing after today's class


class MyHashMap:

    # initialize hash table using bucket class
    def __init__(self):
        self.key_size = 769
        self.hash_tab = [Bucket() for i in range(self.key_size)]
        
    def put(self, key: int, value: int) -> None:
        hash_key = key % self.key_size
        self.hash_tab[hash_key].update(key, value)

    def get(self, key: int) -> int:
        hash_key = key % self.key_size
        return self.hash_tab[hash_key].get(key)
        
    def remove(self, key: int) -> None:
        hash_key = key % self.key_size
        self.hash_tab[hash_key].remove(key)
        
class Bucket:
    
    def __init__(self):
        self.bucket = []
        
    # iterate through bucket to get the key value
    def get(self, key):
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1
        
    # enumerate the bucket to find the key value pair and  update them if exists
    def update(self, key, value):
        found = False
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                self.bucket[i] = (key, value)
                found = True
                break
        
        # if not append the pair
        if not found:
            self.bucket.append((key, value))
            
    def remove(self, key):
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)