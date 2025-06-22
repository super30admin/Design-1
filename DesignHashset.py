"""
Solution 1: Create an array of size 10^6 which is the range of keys the hashmap is supporting --> no collisions but wastage of space.

Solution 2 (Optimal): Create a primary array of size square root (10^6) = 10^3 (Not valid root then use ceil or floor). Initialize with None. Don't initialize the secondary array now (If the key space isn't dense, we might waste memory so we lazy-initialize inner lists to lower the wastage). When a key is added, only then initialize the index position from hash1 with secondary array of size 10^3 and store key in index position provided by hash2. Here choice of primary array size, hash functions will help avoid collisions.
hash1 = k % 1001 → gives 0 to 1000
hash2 = k // 1001 → gives 0 to 1000 (because 10^6 // 1000 = 1000)
Each key is uniquely mapped to a row, column position. No two keys will land on the same slot. No collisions, guaranteed. Modulo and division split the key uniquely. The entire key space is covered exactly without overlaps or gaps. Each key = (hash2 * 1000) + hash1 → uniquely reversible. It is also deterministic i.e. for same input, it is giving same output.

Edge cases:
1. duplicate addition (will be overwritten).
2. Store extreme keys i.e. 10^6.
3. empty secondary list. (Initialzed with None)
4. empty primary list. (Initialized with None)
5. element is not present.

Time Complexity:
add: O(1)
contains: O(1)
remove: O(1)
Space Complexity: O(n)
"""

class Hashset():
  def __init__(self):
    self.storage = [None] * 1000 # index range is 0 to 999. Initilze with None as it is Pythonic but even boolean system is okay as we are just tracking occupancy and will occupy less space.
    
  def add(self, key):
    self.bucket = self.hash1(key)
    self.bucketList = self.hash2(key)
    
    if self.storage[self.bucket] == None:
      if self.bucket == 0:
        self.storage[self.bucket] = [None] * 1001 # only needed for index 0
      else:
        self.storage[self.bucket] = [None] * 1000
    self.storage[self.bucket][self.bucketList] = key
    
    
  def contains(self, key):
    self.bucket = self.hash1(key)
    self.bucketList = self.hash2(key)
    if self.storage[self.bucket] is not None: 
      #return f"Key {key} found" if self.storage[self.bucket][self.bucketList] is not None else f"Key {key} not found"
      return True if self.storage[self.bucket][self.bucketList] == key else False
    #return f"Key {key} not found"
    return False
    
    
  def remove(self, key):
    self.bucket = self.hash1(key)
    self.bucketList = self.hash2(key)
    if self.storage[self.bucket] is None: 
      #return f"Key {key} not found. So cannot be removed"
      return
    self.storage[self.bucket][self.bucketList] = None
    #return f"Key {key} removed."
    
    
  def hash1(self, key):
    return key%(len(self.storage))
    
    
  def hash2(self, key):
    return key//len(self.storage)
  
  
  def __str__(self):
    print(self.storage)
  

myHashset = Hashset()
myHashset.add(5)
myHashset.add(18)
myHashset.add(1000)
print(myHashset.contains(8))
print(myHashset.contains(1000))
print(myHashset.remove(18))
print(myHashset.remove(78))
print(myHashset.contains(18))