# Time Complexity : O(N/K) where K is key range or number of buckets
# Space Complexity : O(K+M) where M is number of unique values inserted in Hashset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        self.key_range = 2000
        self.hash_table = [Bucket() for i in range(self.key_range)]

    def put(self, key: int, value: int) -> None:
        hash_key = key % self.key_range
        self.hash_table[hash_key].update(key, value)

    def get(self, key: int) -> int:
        hash_key = key % self.key_range
        return self.hash_table[hash_key].get(key)

    def remove(self, key: int) -> None:
        hash_key = key % self.key_range
        self.hash_table[hash_key].remove(key)
        
        
class Bucket:
    def __init__(self):
        self.bucket = []

    def get(self, key):
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1

    def update(self, key, value):
        exists = False
        for i, key_val in enumerate(self.bucket):
            if key == key_val[0]:
                self.bucket[i] = (key, value)
                exists = True
                break

        if not exists:
            self.bucket.append((key, value))

    def remove(self, key):
        for i, key_val in enumerate(self.bucket):
            if key == key_val[0]:
                del self.bucket[i]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)