
#A hash set data structure is implemented by the MyHashSet class using a dictionary.
#The dictionary has keys for each bucket, and each bucket's corresponding value is a collection of its contents.
#The dictionary is processed by the add, remove, and contains methods in the order of adding, removing, and determining whether or not a hash set element already exists.
#Time complexity O(1)
#space complexity O(1)


class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = {}

    def bucket(self, key):
        return key % self.buckets

    def bucketItem(self, key):
        return key // self.bucketItems

    def add(self, key):
        a = self.bucket(key)
        b = self.bucketItem(key)
        if a not in self.storage:
            self.storage[a] = set()
        self.storage[a].add(b)

    def remove(self, key):
        a = self.bucket(key)
        b = self.bucketItem(key)
        if a in self.storage and b in self.storage[a]:
            self.storage[a].remove(b)

    def contains(self, key):
        a = self.bucket(key)
        b = self.bucketItem(key)
        return a in self.storage and b in self.storage[a]
    

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)