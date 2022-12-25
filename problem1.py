"""
Time Complexity: Time Complexity for every function is O(1)
Space Complexity: O(buckets * bucketItems)

Approach:
A. BruteForce:
Create an array of 1M + 1 with Hash Function key % 1M.
This is not efficient because it consumes large memory.

B. 
- For HashMap, Hashtable and HashSeet searching and insertion should be done in O(1). 
- We can use nested array to design hashset and double hashing. 
  Second hashing function is use to deal with the collision

Hash1: Modulus operation (%)
Hash2: Division Operation (//)

- The ideal Hash function will be one-one mapping between key and bucket. 
  But in practive, we try to assign key to nucket as uniformly as we can. 
  So here, the range is 0 to 1M, 1000 buckets and bucketItems is selected sqrt(1M)
"""

class MyHashSet:

    def __init__(self):
        self.__storage = [None] * 1000
        self.__buckets = 1000
        self.__bucketItems = 1000

    def hash1(self,key):
        """Time Complexity: O(1)"""
        return key % self.__buckets
    
    def hash2(self,key):
        """Time Complexity: O(1)"""
        return key // self.__bucketItems

    def add(self, key: int) -> None:
        """Time Complexity: O(1)"""
        firstHash = self.hash1(key)

        if self.__storage[firstHash] == None:
            if firstHash == 0:
                self.__storage[firstHash] = [False] * (self.__bucketItems + 1)
            else:
                self.__storage[firstHash] = [False] * self.__bucketItems
        
        secondHash = self.hash2(key)
        self.__storage[firstHash][secondHash] = True

    def remove(self, key: int) -> None:
        """Time Complexity: O(1)"""
        firstHash = self.hash1(key)
        if self.__storage[firstHash] == None:
            return
        
        secondHash = self.hash2(key)
        self.__storage[firstHash][secondHash] = False

    def contains(self, key: int) -> bool:
        """Time Complexity: O(1)"""
        firstHash = self.hash1(key)
        if self.__storage[firstHash] == None:
            return False
        
        secondHash = self.hash2(key)
        return self.__storage[firstHash][secondHash]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)