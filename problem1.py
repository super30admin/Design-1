#Time Complexity : O(1) ... n is number of elements 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : faced some issue with the add function initially

#Using the linear chaining approach to store the elements in the hash map.

class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [[] for _ in range(self.buckets)]

    def bucket(self, key):
        return key % self.buckets

    def bucketItem(self, key):
        return key // self.bucketItems

    def add(self, key):
        a = self.bucket(key)
        b = self.bucketItem(key)
        while len(self.storage[a]) <= b:
            self.storage[a].append(False)
        self.storage[a][b] = True

    def remove(self, key):
        a = self.bucket(key)
        b = self.bucketItem(key)
        if len(self.storage[a]) > b:
            self.storage[a][b] = False

    def contains(self, key):
        a = self.bucket(key)
        b = self.bucketItem(key)
        if len(self.storage[a]) > b:
            return self.storage[a][b]
        return False




# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
