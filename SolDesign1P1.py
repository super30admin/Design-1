"""
LC 705. Design a Hash Set
-Time Complexity : 
    add = O(1)
    remove = O(1)
    contains = O(1)
-Space Complexity : 
    worst case O(K * M) where K= number of buckets and M = max number of 
    elements in each bucket
-Did this code successfully run on Leetcode :
Yes
-Any problem you faced while coding this : 
Yes. Trouble intializing the list with None and then updating it to store 
the newly formed list of booleans. Python showed an error. 
-Your code here along with comments explaining your approach
I used double hashing method as the collision avoidance method. 
Step1 . Intitalize the number of buckets with None.
Calcualte bucket, bucketItem from the key using hash fnxs. 
Step2. Add fxn = if bucket is Null, create a new boolean list with size M 
and mark the index = "key" as True
Step3. Remove fxn = if bucket is Null, return from the fxn. Otherwise, mark
the element as false in its respective place
Step4. Contains fnx = If there is no bucket list, return False, else return the
desired index in the bucket.
"""

class MyHashSet:

    def __init__(self):
        self.buckets = [None for x in range(1000)]

    def findHash(self, key):
        return key % 1000, key // 1000

    def add(self, key: int) -> None:
        bucket, bucketItem = self.findHash(key)
        if self.buckets[bucket] == None:
            if bucket == 0:
                self.buckets[bucket] = [False for x in range(1001)]
            else:
                self.buckets[bucket] = [False for x in range(1000)]
        self.buckets[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket, bucketItem = self.findHash(key)
        if self.buckets[bucket] == None:
            return
        else:
            self.buckets[bucket][bucketItem] = False
        
    def contains(self, key: int) -> bool:
        bucket, bucketItem = self.findHash(key)
        if self.buckets[bucket] == None:
            return False
        return self.buckets[bucket][bucketItem]