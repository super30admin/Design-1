"""
two-level hashing scheme where:
buckets = 1000
bucketItems = 1000
Hash functions:
h1(key) = key % buckets → Gives the bucket index
h2(key) = key // bucketItems → Gives the item index within the bucket
This technique avoids allocating a huge flat array (like a million-size array) by using a 2D array, 
enabling space-efficient HashSet design, especially when the maximum key range is up to 10⁶.
// Time Complexity : O(1) per function
// Space Complexity : Amortized O(1) per function
"""

class MyHashSet:

    def __init__(self):

        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None]*1000

    def hash1(self,key):
        return key % self.buckets

    def hash2(self,key):
        return key // self.bucketItems
        
    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[bucket] is None:

            if bucket == 0:
                self.storage[bucket] = [False]*(self.bucketItems + 1)

            else:
                self.storage[bucket] = [False] * self.bucketItems

        self.storage[bucket][bucketItem]= True

        
    def remove(self, key: int) -> None:

        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        if(self.storage[bucket] is not None):
            self.storage[bucket][bucketItem] = False


    def contains(self, key: int) -> bool:

        bucket = self.hash1(key)
        bucketItem = self.hash2(key)

        return self.storage[bucket] is not None and self.storage[bucket][bucketItem]



       
          
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)