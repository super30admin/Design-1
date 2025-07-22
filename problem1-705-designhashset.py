#Time Complexity :
#for adding time complexity 0(1)
#for remove time complexity 0(1)
#for contains time complexity 0(1)

#space complexity O(n + m)

# double hashing technique

class MyHashSet:

    def __init__(self):
        self.bucket_size = 1000
        self.sub_bucket_size = 1000
        self.bucket = [None] * self.bucket_size

    def hash1(self, key: int) -> int:
        return key % self.bucket_size

    def hash2(self, key: int) -> int:
        return key // self.sub_bucket_size

    def add(self, key: int) -> None:
        bucket_loc = self.hash1(key)
        if self.bucket[bucket_loc] is None:
            self.bucket[bucket_loc] = [False] * (self.sub_bucket_size + 1 if bucket_loc == 0 else self.sub_bucket_size)
        sub_bucket_location = self.hash2(key)
        self.bucket[bucket_loc][sub_bucket_location] = True

    def remove(self, key: int) -> None:
        bucket_loc = self.hash1(key)
        if self.bucket[bucket_loc] is None:
            return
        sub_bucket_location = self.hash2(key)
        self.bucket[bucket_loc][sub_bucket_location] = False

    def contains(self, key: int) -> bool:
        bucket_loc = self.hash1(key)
        if self.bucket[bucket_loc] is None:
            return False
        sub_bucket_location = self.hash2(key)
        return self.bucket[bucket_loc][sub_bucket_location]

