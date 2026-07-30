# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : had to use module division when calculating key hash for secondary array.


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        # length os thousand is derived by taking the squre root of 10^6 [input constraint]
        self.primaryarraylength = 1000
        self.secondaryarraylength = 1000
        self.storage = [None] * self.primaryarraylength

    #utility methods to get the key hash for primary array
    def getPrimaryKeyHash(self, key):
        return key % self.primaryarraylength
    
    #utility method to get the key hash for secondary array
    def getSecondaryKeyHash(self, key):
        return key // self.secondaryarraylength

    # Adds a key to the hash set
    #Working mechanism: so basically we are having two arrays [double hashing technique is being used]. primary array has 0-999 indices. so basically when we take the input key and modulo it by 1000, the result value falls in this index range. now we take the same key and do integer division operation so that it always falls in the range of 0-1000. so we have indices from 0-1000 in secondary array. so basically by doing this we get two index values, one is for primary array and second is for secondary array. so idea is to have a 2d array which is our storage. since we want operations to happenin O(1) time complexity, instead of storing int values/ keys we just use booleans. and set the appropriate flags in the position. we do this since removing a element from the array involve shifting elements which is O(N). so now lets say 10 is the key, we do 10 % 1000 which is 10. this is the index in primary array and now we do 10 / 1000 which is 0 and this is index in secondary array - secondary array in 10th index of primary array has exactly 1001 slots 0-1000 indices. so in that particular index we set value as true. so idea is since we have 1000 slots in primary array and 10^6 is the input array range. each bucket in primary array can hold 1000 elements. so setting flag in that bucket to true or false helps us determine if key exists or does not exists. similarly for removing the key we just set the appropriate bucket to false.
    def add(self, key: int) -> None:
        primaryarraykeyhash = self.getPrimaryKeyHash(key)
        if self.storage[primaryarraykeyhash] is None:
            if primaryarraykeyhash == 0:
                self.storage[primaryarraykeyhash] = [False] * (self.secondaryarraylength + 1)
            else:
                self.storage[primaryarraykeyhash] = [False] * self.secondaryarraylength
        secondaryarraykeyhash = self.getSecondaryKeyHash(key)
        self.storage[primaryarraykeyhash][secondaryarraykeyhash] = True

    # Removes a key from the hash set
    def remove(self, key: int) -> None:
        primaryarraykeyhash = self.getPrimaryKeyHash(key)
        if self.storage[primaryarraykeyhash] is None:
            return
        secondaryarraykeyhash = self.getSecondaryKeyHash(key)
        self.storage[primaryarraykeyhash][secondaryarraykeyhash] = False

    #Searches for a key in hashset will return true if key exists otherwise will return false.
    def contains(self, key: int) -> bool:
        primaryarraykeyhash = self.getPrimaryKeyHash(key)
        if self.storage[primaryarraykeyhash] is None:
            return False
        secondaryarraykeyhash = self.getSecondaryKeyHash(key)
        return self.storage[primaryarraykeyhash][secondaryarraykeyhash]
            

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)