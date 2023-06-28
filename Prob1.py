# Time Complexity : All opertions are O(1)
# Space Complexity : O(n) n in the max number of elements on the array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
#   Used double hasing to avoid collision.
#   1. Intiaited buckets llist with None and calculated bucket(secondary array) and bucketItem(index of bucket array)
#   2. In add fucntion, if "bucket" is Null, created a boolean list and mark True if key is present else False by default.
#   3. Similarly in remove fucntion, if "bucket" is not Null, mark that index as False, else return
#   4. In contains fucntion, if index exsists in the secondary list return it else return False.
class MyHashSet:

    def __init__(self):
        self.buckets=[None for x in range(1000)]

    def hash1(self,key):
        return key%1000
    def hash2(self,key):
        return key//1000

    def add(self, key: int) -> None:
        bucket,bucketItem=self.hash1(key),self.hash2(key)
        if self.buckets[bucket]==None:
            if bucket==0:
                self.buckets[bucket]=[False for x in range(1001)]
            else:
                self.buckets[bucket]=[False for x in range(1000)]
        self.buckets[bucket][bucketItem]=True

    def remove(self, key: int) -> None:
        bucket,bucketItem=self.hash1(key),self.hash2(key)
        if self.buckets[bucket]==None:
            return
        self.buckets[bucket][bucketItem]=False
    def contains(self, key: int) -> bool:
        bucket,bucketItem=self.hash1(key),self.hash2(key)
        if self.buckets[bucket]==None:
            return False
        return self.buckets[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)