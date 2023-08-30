# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucket_item = 1000
        self.hashset = [None]*self.bucket

    def add(self, key: int) -> None:
        hash_bucket = key%1000
        hash_bucket_item = key//1000
        if not self.hashset[hash_bucket]:
            if key == 0 or key == 1000000:
                self.hashset[hash_bucket] = [False]*(self.bucket_item+1)
            else:
                self.hashset[hash_bucket] = [False]*self.bucket_item
        self.hashset[hash_bucket][hash_bucket_item] = True


    def remove(self, key: int) -> None:
        hash_bucket = key%1000
        hash_bucket_item = key//1000
        if not self.hashset[hash_bucket]:
            return
        self.hashset[hash_bucket][hash_bucket_item] = False

    def contains(self, key: int) -> bool:
        hash_bucket = key%1000
        hash_bucket_item = key//1000

        return self.hashset[hash_bucket][hash_bucket_item] if self.hashset[hash_bucket] else False
        