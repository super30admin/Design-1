# Time Complexity : O(1)
# Space Complexity : O(N+size)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Was thinking of what ways can unique hashing be achieved to reduce collisions without using libraries


# Your code here along with comments explaining your approach
    # - Use a list, max it out to reduce collision
    # - Use a simple modulo approach to set the hashkey for a key
class MyHashSet:

    def __init__(self):
        self.size = 10000 # Initializing hashset size to be this, to avoid collisions
        # creating buckets to store
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key):
        return key % self.size # setting up the unique hash for the key
    def add(self, key: int) -> None:
        h = self._hash(key) # set the hash for the key
        bucket = self.buckets[h] # get the bucket info
        if key not in  bucket: #mcheck if the key does not exists in the bucket
            bucket.append(key)

    def remove(self, key: int) -> None:
        h = self._hash(key) # set the hash for the key
        bucket = self.buckets[h]  # get the bucket info
        try:
            bucket.remove(key) # remove key if exists
        except ValueError:
            pass # else ignore

    def contains(self, key: int) -> bool:
        h = self._hash(key) # set the hash for the key
        bucket = self.buckets[h]  # get the bucket info
        return key in bucket # returns true or false 


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)