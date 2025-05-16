#Using double hashing
#TC is O(1) for all
#SC is O(n) for add, O(1) for other

class MyHashSet:

    def __init__(self):
        self.buckets = 1000 #outer
        self.bucketItems = 1000 #inner: number of items per bucket
        self.storage = [None] * self.buckets #Initialize Outer array with None

    def hash1(self, key):
        # First hash function to find the bucket index
        return key % self.buckets

    def hash2(self, key):
        # Second hash function to find the index within the bucket
        return key // self.buckets

    def add(self, key: int) -> None:
        index1 = self.hash1(key)
        # If the bucket does not exist, initialize it
        if self.storage[index1] is None:
            if index1==0:
                self.storage[index1] = [False] * (self.bucketItems + 1)
            else:
                self.storage[index1] = [False] * self.bucketItems
        
        # Mark the key as present
        index2 = self.hash2(key)
        self.storage[index1][index2] = True

    def remove(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] is None:
            return
        self.storage[index1][index2] = False
    
    def contains(self, key: int) -> bool:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] is None:
            return False
        return self.storage[index1][index2]