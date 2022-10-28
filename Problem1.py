# Time Complexity:
# Add - O(1), Remove - O (1), Contains - O (1)

# Space Complexity: 
# O(n*m) where n is bucket size and m is bucketItem size
# O(10^6) in this case

#Accepted on Leetcode

# Approach
# Double Hashing approach, here we will use two hash functions
# First Hash will select a primary index and second hash will select secondary index
# Keys are between 0 to 10^6 so unique value we can take as size is 10^3
# Primary bucket 10^3 and each primary bucket will have secondary bucket of size 10^3



class MyHashSet:
    
    buckets = 1000
    bucketItems = 1000

    def __init__(self):
        self.storageArr = [False for i in range(MyHashSet.buckets)]
        

    def add(self, key: int) -> None:
        primaryIdx = self.hash1(key)
        secondaryIdx = self.hash2(key)
        
        bucket = self.storageArr[primaryIdx]
        
        if bucket == False:
            if bucket == 0: #handling edge case for key = 10**6
                bucket = self.storageArr[primaryIdx] = [False for i in range(MyHashSet.bucketItems + 1)]
            else:
                bucket = self.storageArr[primaryIdx] = [False for i in range(MyHashSet.bucketItems)]
        
        bucket[secondaryIdx] = True
        
    
    def hash1(self, key):
        return key % MyHashSet.buckets
    
    def hash2(self, key):
        return key // MyHashSet.bucketItems
        

    def remove(self, key: int) -> None:
        primaryIdx = self.hash1(key)
        secondaryIdx = self.hash2(key)
        
        bucket = self.storageArr[primaryIdx]
        
        if bucket != False:
            bucket[secondaryIdx] = False

    def contains(self, key: int) -> bool:
        primaryIdx = self.hash1(key)
        secondaryIdx = self.hash2(key)
        
        bucket = self.storageArr[primaryIdx]
        
        if bucket == False:
            return False
        else:
            return bucket[secondaryIdx]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)