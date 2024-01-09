# Design Hashset
# Using Double Hashing technique to avoid collision which means we have two hash functions one for accessing the bucket and 
# another for accessing the index when the first hash function produces same value for different items
# Time Complexity: add/remove/contains -> O(1)
# Space Complexity: O(1) not including the data storage

# Submitted in leetcode
class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucket_items = 1000
        self.data = [None for i in range(self.buckets)]

    def add(self, key: int) -> None:
        bucket = self.get_hash_val1(key)
        bucket_item = self.get_hash_val2(key)
        if self.data[bucket] is None:
            if bucket == 0:
                self.data[bucket] = [False] * (self.bucket_items+1)
            else:
                self.data[bucket] = [False] * self.bucket_items
        self.data[bucket][bucket_item] = True


    def remove(self, key: int) -> None:
        if self.contains(key):
            self.data[self.get_hash_val1(key)][self.get_hash_val2(key)] = False
        
        

    def contains(self, key: int) -> bool:
        bucket = self.get_hash_val1(key)
        if self.data[bucket] is None:
            return False
        else:
            return self.data[bucket][self.get_hash_val2(key)]


    def get_hash_val1(self,key:int):
        return int(key % self.buckets)

    def get_hash_val2(self,key:int):
        return int(key / self.bucket_items)

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)