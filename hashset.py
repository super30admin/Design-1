# Time Complexity :all operations will perform in O(1)
# Space Complexity : O(n+m) n=buckets m=bucketItems
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Using doubly hashing method, faced some issue while implementing in
#python, overall concept is clear


class MyHashSet:
        
    def __init__(self):
        self.buckets = 1000 #primary array
        self.bucketItems = 1000 #secondary array
        self.storage = [[False]*self.bucketItems for _ in range(self.buckets)]
    
    def hash1(self, key: int) -> int:
        return key % self.buckets
    
    def hash2(self, key: int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        buckets = self.hash1(key)
        bucketItems = self.hash2(key)
        if all(not x for x in self.storage[buckets]):
            if(buckets == 0):
                self.storage[buckets] = [False]*(self.bucketItems+1)
            else:
                self.storage[buckets] = [False]*(self.bucketItems)
        
        self.storage[buckets][bucketItems] = True

        
    def remove(self, key: int) -> None:
        buckets = self.hash1(key)
        bucketItems = self.hash2(key)
        if all(not x for x in self.storage[buckets]):
            return
        self.storage[buckets][bucketItems] = False


    def contains(self, key: int) -> bool:
        buckets = self.hash1(key)
        bucketItems = self.hash2(key)
        if all(not x for x in self.storage[buckets]):
            return False
        return self.storage[buckets][bucketItems]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)