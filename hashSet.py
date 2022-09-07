# Time Complexity : O(1)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:
    def __init__(self):
        self.bucketSize = 1000
        self.bucket = [None] * 1000

    def get_bucket_id(self, key):
        return key % len(self.bucket)

    def get_secondary_bucket_id(self, key):
        return key // self.bucketSize

    def add(self, key):
        bucket_id = self.get_bucket_id(key)
        sec_bucket_id = self.get_secondary_bucket_id(key)

        if not self.bucket[bucket_id]:
            if bucket_id == 0:
                self.bucket[bucket_id] = [False] * (self.bucketSize + 1)
            else:
                self.bucket[bucket_id] = [False] * self.bucketSize
        self.bucket[bucket_id][sec_bucket_id] = True

    def remove(self, key):
        bucket_id = self.get_bucket_id(key)
        sec_bucket_id = self.get_secondary_bucket_id(key)

        if not self.bucket[bucket_id]:
            return
        else:
            self.bucket[bucket_id][sec_bucket_id] = False

    def contains(self, key):
        bucket_id = self.get_bucket_id(key)
        sec_bucket_id = self.get_secondary_bucket_id(key)
        if self.bucket[bucket_id]:
            return self.bucket[bucket_id][sec_bucket_id]
        return False


obj = MyHashSet()
obj.add(3333)
obj.add(2343)
obj.remove(33313)
param_3 = obj.contains(3333)
print(param_3)
