# Time Complexity : o(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Not in this problem

""" Created two Hash functions one find index in outer bucket
and second find index in nested bucket according to this logic I have done
add, remove and contains functionality"""


class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def add(self, key: int) -> None:
        bucketNumber = key % self.buckets
        if self.storage[bucketNumber] == None:
            if bucketNumber == 0:
                self.storage[bucketNumber] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucketNumber] = [None] * self.bucketItems
        nestedBucketNumber = key // self.bucketItems

        self.storage[bucketNumber][nestedBucketNumber] = key

    def remove(self, key: int) -> None:
        bucketNumber = key % self.buckets
        if self.storage[bucketNumber] != None:
            nestedBucketNumber = key // self.bucketItems
            self.storage[bucketNumber][nestedBucketNumber] = None

    def contains(self, key: int) -> bool:
        bucketNumber = key % self.buckets
        if self.storage[bucketNumber] != None:
            nestedBucketNumber = key // self.bucketItems
            return self.storage[bucketNumber][nestedBucketNumber] == key
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
