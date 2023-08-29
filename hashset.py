# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class MyHashSet:
    
    def __init__(self):
        self.list = [False]*1000                # Created list of false with size 1000 which is 10**6 / 2

    def getBucket(self, key):
        return key % 1000                       # get index of array

    def getBucketItems(self, key):
        return key//1000                        # get Index of array of array

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)  
        bucketItem = self.getBucketItems(key)
        if self.list[bucket] == False:          # check if array index False
            if bucket == 0:             
                self.list[bucket] = [False]*1001  # if index 0 then have create size 1001 for include 10**6th element
            else:
                self.list[bucket] = [False]*1000  # if not then have create size 1000 
        self.list[bucket][bucketItem] = True    # assign true to perticuler index


    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)
        if self.list[bucket] != False: 
            self.list[bucket][bucketItem] = False # if bucket is True then asssign False to perticuler index

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)
        if self.list[bucket] != False:
            return self.list[bucket][bucketItem] # if bucket is True then return perticuler index's boolean value
        return False                             # else return False


