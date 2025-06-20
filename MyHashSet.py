
# Time Complexity - O(1) - all operations can be done in constant time.
# Space Complexity - 10^6 storage for this implementation. In general it's O(buckets * bucket_size)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Implemented Hashset by storing all elements in a 2D array, passing through 2 hash functions.

class MyHashSet:
    hashset=[]

    def hash_function1(self, key):
        return key%1000
    
    def hash_function2(self, key):
        return key//1000

    def __init__(self):
        self.hashset = [[] for _ in range(1000)]

    def add(self, key: int) -> None:
        bucket_number = self.hash_function1(key)
        if len(self.hashset[bucket_number]) == 0:
            self.hashset[bucket_number] = [False for _ in range(1001)]
        index = self.hash_function2(key)
        self.hashset[bucket_number][index] = True

    def remove(self, key: int) -> None:
        bucket_number = self.hash_function1(key)
        index = self.hash_function2(key)
        if not self.hashset[bucket_number]:
            return
        self.hashset[bucket_number][index] = False

    def contains(self, key: int) -> bool:
        bucket_number = self.hash_function1(key)
        if not self.hashset[bucket_number]:
            return False
        index = self.hash_function2(key)
        return self.hashset[bucket_number][index]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)