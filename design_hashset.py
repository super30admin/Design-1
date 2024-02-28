# Time Complexity : O(1)
# Space Complexity : O(n) As an array with the size 1000 with None values is initialized
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I was able to understand the logic, but faced issues while implementing it in Python. 


# Your code here along with comments explaining your approach
# I used double hashing method. I also implemented the array according to constraints given in the problem. 

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.array = [None] * self.buckets

    def hf1(self, key:int):
        return key % self.buckets

    def hf2(self, key:int):
        return key // self.bucketitems

    def add(self, key: int) -> None:
        bucket = self.hf1(key)
        bucketitems = self.hf2(key)

        if self.array[bucket] is None:
            if bucket == 0:
                self.array[bucket] = [False] * (self.bucketitems + 1)
            else:
                self.array[bucket] = [False] * self.bucketitems

        self.array[bucket][bucketitems] = True

    def remove(self, key: int) -> None:
        bucket = self.hf1(key)
        bucketitems = self.hf2(key)
        if self.array[bucket] is None:
            return 
        self.array[bucket][bucketitems] = False


    def contains(self, key: int) -> bool:
        bucket = self.hf1(key)
        bucketitems = self.hf2(key)
        if self.array[bucket] is None:
            return False
        return self.array[bucket][bucketitems] 

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
