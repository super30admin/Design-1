// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1001
        self.hashset = [[None] for i in range(self.buckets)]
        
    def hashFun(self, value) :
        return value % self.buckets
    
    def hashFunBucket(self, value) :
        return value // self.bucketItems      

    def add(self, key: int) -> None:
        bucket = self.hashFun(key)
        if self.hashset[bucket] == [None] :
            self.hashset[bucket] = [None for i in range(self.bucketItems)]
        placementInBucket = self.hashFunBucket(key)
        self.hashset[bucket][placementInBucket] = True 
        

    def remove(self, key: int) -> None:
        bucket = self.hashFun(key)
        if self.hashset[bucket] == [None] :
            return
        placementInBucket = self.hashFunBucket(key)
        self.hashset[bucket][placementInBucket] = False    

    def contains(self, key: int) -> bool:
        bucket = self.hashFun(key)
        placementInBucket = self.hashFunBucket(key)
        return self.hashset[bucket] != [None] and self.hashset[bucket][placementInBucket]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
