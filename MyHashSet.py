# Time Complexity :  O(1) - For all 3 functions
# Space Complexity : O(1) for remove and contains, but for add may be it can change based on input O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class MyHashSet:

    def __init__(self):
        #size of my primary bucket, took square root of max constraint value
        self.b1 = 1000
        #size of secondary array which will be dynamically allocated
        self.b2 = 1000
        self.storage = [None] * self.b1
    #calculating the primary hash which will give index for b1 bucket
    def primaryHash(self, key: int) -> int:
        return key % self.b1

    # calculating the secondary hash which will give index for b2 bucket
    def secondaryHash(self, key: int) -> int:
        return key // self.b2

    def add(self, key: int) -> None:
        p1 = self.primaryHash(key)
        if self.storage[p1] is None:
            #handling the edge case if the key value is max constraint value (to avoid out of index issue)
            if p1 == 0:
                self.storage[p1] = [False] * (self.b2 + 1)
            else:
                self.storage[p1] = [False] * self.b2
        p2 = self.secondaryHash(key)
        #Setting true at this location storage[p1][p2]
        self.storage[p1][p2] = True

    def remove(self, key: int) -> None:
        p1 = self.primaryHash(key)
        # return nothing if storage[p1] is None, no need to check p2 index
        if self.storage[p1] is None:
            return
        p2 = self.secondaryHash(key)
        # Setting False at this location storage[p1][p2]
        self.storage[p1][p2] = False

    def contains(self, key: int) -> bool:
        p1 = self.primaryHash(key)
        # return False if storage[p1] is None, no need to check p2 index
        if self.storage[p1] is None:
            return False
        p2 = self.secondaryHash(key)
        return self.storage[p1][p2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)