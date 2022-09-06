# Time Complexity : O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Unfamiliar with double hashing, so was challenging to learn and implement

class HashSet:
    def __init__(self):
        self.bucketSize = 1000
        self.hashSet = [None] * self.bucketSize

    def hash1(self, key):
        return key % self.bucketSize

    def hash2(self, key):
        return key // self.bucketSize

    def add(self, key):
        hash1Val = self.hash1(key)
        hash2Val = self.hash2(key)

        if not self.hashSet[hash1Val] and hash1Val == 0:
            self.hashSet[hash1Val] = [False] * (self.bucketSize + 1)
        elif not self.hashSet[hash1Val]:
            self.hashSet[hash1Val] = [False] * self.bucketSize
        self.hashSet[hash1Val][hash2Val] = True

    def remove(self, key):
        hash1Val = self.hash1(key)
        hash2Val = self.hash2(key)

        if self.hashSet[hash1Val]:
            self.hashSet[hash1Val][hash2Val] = False

    def contains(self, key):
        hash1Val = self.hash1(key)
        hash2Val = self.hash2(key)

        if self.hashSet[hash1Val]:
            return self.hashSet[hash1Val][hash2Val]
        return False


obj = HashSet()
obj.add(3333)
obj.add(2343)
obj.remove(33313)
param_3 = obj.contains(3333)
print(param_3)





