class MyHashSet:
    
    def __init__(self, bucket_size: int = 769):
        self.bucket_size = bucket_size
        self.buckets = [[] for _ in range(bucket_size)]
    
    def _hash(self, key: int) -> int:
        return key % self.bucket_size

    def add(self, key: int) -> None:
        bucket = self.buckets[self._hash(key)]
        for v in bucket:
            if v == key:
                return 
        bucket.append(key)
        

    def remove(self, key: int) -> None:
        bucket = self.buckets[self._hash(key)]
        for i,v in enumerate(bucket):
            if v == key:
                bucket.pop(i)
                return
        

    def contains(self, key: int) -> bool:
        bucket = self.buckets[self._hash(key)]
        for v in bucket:
            if v == key:
               return True
        return False

 
def demo():
    hs = MyHashSet()
    print("Adding 1 and 2")
    hs.add(1)
    hs.add(2)

    print("contains(1)?", hs.contains(1))  # True
    print("contains(3)?", hs.contains(3))  # False

    print("Adding 2 again (should be no-op)")
    hs.add(2)
    print("contains(2)?", hs.contains(2))  # True

    print("Removing 2")
    hs.remove(2)
    print("contains(2)?", hs.contains(2))  # False

    print("All done!")


if __name__ == "__main__":
    demo()

# Time Complexity :  O(1)
# Space Complexity : O(n) for n keys stored
# Did this code successfully run on Leetcode : Yes, 705 (Design_HashSet)
# Any problem you faced while coding this :  no , i learnt that using 769 prime numbers for buckets can reduce collisions
