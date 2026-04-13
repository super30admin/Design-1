'''
Approach of the code:

Instead of create a large array of 10^6, I am using 1000 buckets to hash the key that can handle collisions


'''

class MyHashSet:

    def __init__(self):
        self.primaryBucket = 1000
        self.secondaryBucket = 1000
        self.my_set = [None] * self.primaryBucket

    def hash1(self, key):
        return key % self.primaryBucket

    def hash2(self, key):
        return key // self.secondaryBucket

    def add(self, key: int) -> None:
        primary = self.hash1((key))
        if not self.my_set[primary]:
            if primary == 0:
                self.my_set[primary] = [False] * (self.secondaryBucket + 1)
            else:
                self.my_set[primary] = [False] * (self.secondaryBucket)
        secondary = self.hash2(key)
        self.my_set[primary][secondary] = True

    def remove(self, key: int) -> None:
        primary = self.hash1((key))
        if not self.my_set[primary]:
            return
        secondary = self.hash2(key)
        self.my_set[primary][secondary] = False

    def contains(self, key: int) -> bool:
        primary = self.hash1((key))
        if not self.my_set[primary]:
            return False
        secondary = self.hash2(key)
        return self.my_set[primary][secondary]


myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)     
myHashSet.contains(1) 
myHashSet.contains(3) 
myHashSet.add(2)     
myHashSet.contains(2)
myHashSet.remove(2)  
myHashSet.contains(2) 
 
