#Time Complexity : O(1) - add, remove, contains, getBucket, getBucketItem
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketItem = 1000
        self.storage = [None] * self.bucket

    '''This method is used to get the primary index of the array'''
    def getBucket(self, key) -> int:
        bucket = key % self.bucket
        return bucket

    '''This method is used to get the secondary index and to keep track of element stored'''
    def getBucketItem(self, key) -> int:
        bucketItem = key // self.bucketItem
        return bucketItem

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        '''
        if the primary index of array is empty then we will initialize the secondary the secondary array
        and mark the secondary index as True which indicates that key is present in that location.
        '''
        if self.storage[bucket] == None:
            '''
            This is an edge case when the element to be added is 10**6, then the index where the
            element needs to be stored is 1000, so we are adding 1 index to the secondary array 
            for the first bucket, else the number of indexes are from 0 to 999 (since the max elements are 10**6)
            '''
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItem + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItem

        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        '''
        if the primary index is empty which means the key doesn't exist
        so we can simply return else we need to make the secondary index to none
        which indicates that the location is empty/element has been removed
        '''
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = None

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        '''
        if the primary index of the array is empty it returns False
        '''
        if self.storage[bucket] == None:
            return False
        '''
         if the element is present in the secondary index it will return true
            else false
        '''
        return self.storage[bucket][bucketItem] == True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)