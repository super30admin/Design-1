#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :
#Any problem you faced while coding this : I tried doing it with sir's approach
#still I am not sure and will work on it again

# Your code here along with comments explaining your approach

class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = [None] * self.buckets

    def hashkey(self, key):
        return key % self.buckets

    def doublehash(self, key):
        return key / self.buckets

    def add(self, key):
        h = self.hashkey(key)
        dh = self.doublehash(key)
        if not self.bucketItems[h] and h == 0:
            self.bucketItems[h] = [False] * (self.buckets + 1)
        elif not self.bucketItems[h]:
            self.bucketItems[h] = [False] * self.buckets
        self.bucketItems[h][dh] = True

    def remove(self, key):
        h = self.hashkey(key)
        dh = self.doublehash(key)
        if self.bucketItems[h]:
            self.bucketItems[h][dh] = False

    def contains(self, key):
        h = self.hashkey(key)
        dh = self.doublehash(key)
        if self.bucketItems[h]:
            return self.bucketItems[h][dh]
        return False

h = MyHashSet()
h.add(1)    
h.add(2)    
h.add(5)
print(h.contains(1))
print(h.contains(3))
h.add(2)        
print(h.contains(2))
h.remove(2)
print(h.contains(2))
print(h.contains(5))
