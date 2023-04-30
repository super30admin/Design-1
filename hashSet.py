#Time Complexity 
# add method -> O(1)
# contains method -> O(1)
# remove method -> O(1)
#Space Complexity
# O(10 ^ 6) 
# Approach : Using Double Hashing

class MyHashSet:

    def __init__(self):
        #Create a primary array of 1000 elements
        self.storage = [None for i in range(1000)]
        self.buckets = 1000
        self.bucketItems = 1000

    #Primary hash function
    def getBuckets(self,key: int)->int:
        return key % 1000
    #Secondary hash function
    def getBucketItems(self,key: int)->int:
        return key // 1000

    def add(self, key: int) -> None:
        bucket = self.getBuckets(key)
        bucketItem = self.getBucketItems(key)
        
        if self.storage[bucket] == None:
            if bucket == 0:
                #This is an edge case to accomadate the Key "10^6"
                self.storage[bucket] = [False for i in range(self.bucketItems + 1)]
            else:    
                self.storage[bucket] = [False for i in range(self.bucketItems)]
            self.storage[bucket][bucketItem] = True
            return
        self.storage[bucket][bucketItem] = True


    def remove(self, key: int) -> None:
        bucket = self.getBuckets(key)
        bucketItem = self.getBucketItems(key)
        if self.storage[bucket] == None:
            #Here the coulmns are not present in the row, Therefore we can directly return
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.getBuckets(key)
        bucketItem = self.getBucketItems(key)
        if self.storage[bucket] == None:
            #Here the coulmns are not present in the row, Therefore we can directly return False
            return False
        return self.storage[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)