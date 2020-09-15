"""
- Problem: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
    - Implement a HashMap without any built-in libraries.
    - Your implementation should include these three functions:
        put(key, value) : Insert a (key, value) pair into the HashMap or If the value already exists, update the value.
        get(key): Returns the value to which the specified key is mapped, or -1 if  no mapping for the key.
        remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
- Time Complexity: for each of the methods, the time complexity is O(N/K),
        where N is the number of all possible keys and
        K is the number of predefined buckets in the hashmap, which is 2069 in our case.
- Space Complexity: O(K+M), where K is the number of predefined buckets in the hashmap and
        M is the number of unique keys that have been inserted into the hashmap.
"""


class Bucket:
    def __init__(self):
        # Initialize array
        self.bucket = []

    def get(self, key):
        for k, v in self.bucket:
            if k == key:
                return v
        return -1

    def update(self, key, value):
        found = False
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                self.bucket[i] = (key,value)
                found = True
                break

        if not found:
            self.bucket.append((key,value))

    def remove(self,key):
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]


class MyHashMap:
    def __init__(self):
        # Initialize data structure
        self.key_space = 2027  # large prime number
        self.hash_table = [Bucket() for i in range(self.key_space)]

    def put(self, key, value) -> None:
        hash_key = key % self.key_space
        self.hash_table[hash_key].update(key, value)

    def get(self, key) -> int:
        hash_key = key % self.key_space
        return self.hash_table[hash_key].get(key)

    def remove(self, key) -> None:
        hash_key = key % self.key_space
        self.hash_table[hash_key].remove(key)


# Driver code
hashmap = MyHashMap()
hashmap.put(1, 2)
hashmap.put(2, 3)
hashmap.get(1)            # returns 2
hashmap.get(3)            # returns -1 (not found)
hashmap.put(2, 4)         # update the existing value
hashmap.get(2)            # returns 4
hashmap.remove(2)         # remove the mapping for 2
hashmap.get(2)            # returns -1 (not found)