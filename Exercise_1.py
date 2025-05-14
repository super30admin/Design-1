# Time Complexity : O(1) on average for add, remove, contains
# Space Complexity : O(n + k) where n = number of keys, k = number of buckets
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues


class myHashset:
    def __init__(self):
        # make 1000 buckets for chaining
        self.bucket_count = 1000
        self.buckets = [[] for _ in range(self.bucket_count)]

    def hash(self, key):
        # pick a bucket by modulo
        return key % self.bucket_count

    def add(self, key):
        # only add key if it’s not already in its bucket
        idx = self.hash(key)
        bucket = self.buckets[idx]

        for k in bucket:
            if k == key:
                return
        bucket.append(key)

    def remove(self, key):
        # remove key if it's in its bucket
        idx = self.hash(key)
        bucket = self.buckets[idx]

        new_bucket = []
        for k in bucket:
            if k != key:
                new_bucket.append(k)
        self.buckets[idx] = new_bucket

    def contains(self, key):
        # check if key is in its bucket
        idx = self.hash(key)
        bucket = self.buckets[idx]

        for k in bucket:
            if k == key:
                return True
        return False


if __name__ == "__main__":
    obj = myHashset()
    obj.add(1)
    obj.add(2)
    obj.add(1001)
    obj.add(2002)
    obj.add(1003)
    obj.add(3002)

    print(obj.contains(1))     # True
    print(obj.contains(2002))  # True
    print(obj.contains(3))     # False

    obj.remove(2002)
    print(obj.contains(2002))  # False

