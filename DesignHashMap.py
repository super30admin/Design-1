# Time complexity: O(1)
# Space complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # given that the total operations performed will be 10^4, it is safe to consider that value for the number of buckets for hashMap
        self.numBuckets = 10001
        # Using List of List data structure to implement hashmap
        self.hashmap = [[] for _ in range(self.numBuckets)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashkey = key % self.numBuckets
        found = False
        for idx, elem in enumerate(self.hashmap[hashkey]):
            if elem[0] == key:
                self.hashmap[hashkey][idx] = (key, value)
                found = True
                break
        if not found:
            self.hashmap[hashkey].append((key, value))

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashkey = key % self.numBuckets
        for idx, elem in enumerate(self.hashmap[hashkey]):
            if elem[0] == key:
                return elem[1]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashkey = key % self.numBuckets
        for idx, elem in enumerate(self.hashmap[hashkey]):
            if elem[0] == key:
                del self.hashmap[hashkey][idx]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
