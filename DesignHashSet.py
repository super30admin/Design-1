'''
Design-1

Problem 1:(https://leetcode.com/problems/design-hashset/)
'''

class MyHashSet:

    def __init__(self):
        self.buckets = 1000 #primary array size
        self.bucketItems = 1000 #sec array size
        self.storage = [None] * self.buckets #primary array

    def hash1(self, key:int) -> int:
        return key % self.buckets

    def hash2(self, key:int) -> int:
        return key // self.bucketItems   

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItems = self.hash2(key)

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:    
                self.storage[bucket] = [False] * self.bucketItems

        self.storage[bucket][bucketItems] = True    

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItems = self.hash2(key)

        if self.storage[bucket] == None:
            return

        self.storage[bucket][bucketItems] = False    

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItems = self.hash2(key)

        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItems]    


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)