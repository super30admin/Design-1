# Time Complexity : O(1) for add, remove and contains
# Space Complexity : O(n) - secondary arrays are created only when a key needs them
#                    (worst case about 10^6 booleans)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Key 10^6 maps to bucket 0, item 1000,
#                    so bucket 0 needs one extra slot (size 1001)

# Approach: I use double hashing on a 2D boolean array: key % 1000 picks the primary bucket and key // 1000 picks
# the position inside it, so every key from 0 to 10^6 gets its own cell and collisions are impossible.
# A bucket's inner array is created only when its first key is added, and bucket 0 gets one extra slot for key 10^6.



class MyHashSet:

    def __init__(self):

        self.primaryBucket= 1000 # primary array 
        self.secondaryBucket =1000 # secondary array 
        self.storage= [None]*self.primaryBucket
    # Primary hash: decides WHICH ROW the key goes in.
    def getPrimaryhash(self,key): 
        return key % self.primaryBucket
        # Secondary hash: decides WHICH COLUMN inside that row.
    def getSecondaryhash(self,key):
        return key // self.secondaryBucket

    def add(self, key: int) -> None:
        Primaryindex = self.getPrimaryhash(key)
        if self.storage[Primaryindex] is None:
            if Primaryindex == 0:
                self.storage[Primaryindex] = [False]*(self.secondaryBucket+1)
            else:
                self.storage[Primaryindex] = [False]*(self.secondaryBucket)
        secondaryindex = self.getSecondaryhash(key)
        self.storage[Primaryindex][secondaryindex] = True

    def remove(self, key: int) -> None:
         Primaryindex = self.getPrimaryhash(key)
         if self.storage[Primaryindex] is None:
            return 
         secondaryindex = self.getSecondaryhash(key)
         self.storage[Primaryindex][secondaryindex] = False

    def contains(self,key: int) -> bool:
        Primaryindex = self.getPrimaryhash(key)
        if self.storage[Primaryindex] is None:
             return False
        secondaryindex = self.getSecondaryhash(key)
        return self.storage[Primaryindex][secondaryindex]
    
if __name__ == "__main__":
    s = MyHashSet()
    s.add(1)
    s.add(2)
    print(s.contains(1))
    print(s.contains(3))
    s.add(2)
    print(s.contains(2))
    s.remove(2)
    print(s.contains(2))
    




        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)