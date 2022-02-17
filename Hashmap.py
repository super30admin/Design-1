class MyHashMap:
    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def __init__(self):
        self.MAX = 2069
        self.hashmap = [[] for i in range(self.MAX)]

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def hash(self, key):
        hash = key % self.MAX
        return hash

    # Time Complexity : O(n)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def put(self, key: int, value: int) -> None:
        hash = self.hash(key)
        found = False
        for i, e in enumerate(self.hashmap[hash]):
            if len(e)==2 and e[0] == key:
                found = True
                self.hashmap[hash][i] = (key, value)
        if not found:
            self.hashmap[hash].append((key, value))

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def get(self, key: int) -> int:
        hash = self.hash(key)
        for e in self.hashmap[hash]:
            if e[0] == key:
                return e[1]
        return -1

    # Time Complexity : O(n)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
    def remove(self, key: int) -> None:
        hash = self.hash(key)
        for i, e in enumerate(self.hashmap[hash]):
            if e[0] == key:
                del self.hashmap[hash][i]



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
