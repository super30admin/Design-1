#Time Complexity : add-O(1), contains-O(1), remove-O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems =1000
        self.storage = [None] * self.buckets

    def getBucket(self, key:int)-> int:
        return key % self.buckets

    def getbucketItem(self, key:int)-> int:
        return key//self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getbucketItem(key)

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems +1)
            else:
                self.storage[bucket] = [False] * self.bucketItems

        self.storage[bucket][bucketItem] = True

        

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getbucketItem(key)

        if not self.storage[bucket]:
            return

        self.storage[bucket][bucketItem] = False
        

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getbucketItem(key)

        if self.storage[bucket] == None:
            return False

        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)