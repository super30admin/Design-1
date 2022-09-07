# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.buckets = [[] for _ in range(self.size)]
        
    def add(self, key: int) -> None:
        bucket, index = self.getIndex(key)
        if index >= 0:
            return
        bucket.append(key)

    def remove(self, key: int) -> None:
        bucket, index = self.getIndex(key)
        if index < 0:
            return
        bucket.remove(key)
        

    def contains(self, key: int) -> bool:
        bucket, index = self.getIndex(key)
        return index >= 0
         
        
    def hash(self, key):
        return key % self.size
    
    def getIndex(self, key):
        hash = self.hash(key)
        bucket = self.buckets[hash]
        for i, k in enumerate(bucket):
            if k == key:
                return bucket, i
        return bucket, -1


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)