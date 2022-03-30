# Time Complexity : O(1)
# Space Complexity :O(N) where N is the number of elements
# Did this code successfully run on Leetcode : Yes. It got accepted, without any errors.
# Any problem you faced while coding this :Usually with the initialization which is the constructor.
# Don't know if it's still the right one.


# Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [False for i in range(self.buckets)]

    def getBucket(self, key: int) -> int:
        return key % self.buckets

    def getBucketItem(self, key: int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if(self.storage[bucket] == False):
            if(bucket == 0):
                self.storage[bucket] = [
                    False for i in range(self.bucketItems + 1)]

            else:
                self.storage[bucket] = [False for i in range(self.bucketItems)]
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if(self.storage[bucket] == False):
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if(self.storage[bucket] == False):
            return False
        return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
