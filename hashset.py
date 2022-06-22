# time complexity to find/search/add: O(1)
# space complexity: O(N) worst case

#  Approach:
# hashset is list of buckets
# each bucket can contain list of values: array
# using double hashing to avoid collision: 
# buckets = no.of.buckets, initialise the buckets with boolean false
# bucket items = no.of.values inside each bucket
# hash functions: key%buckets and key//bucketitems
# create list of buckets and lists inside buckets.
# initialise buckets as boolean list.

# when we want to add an element, 
# if the bucket is False and bucket is 0, 
# initialise the list inside the bucket
# to fit the edge case,
# length of zeroth bucket will alone be 1001
# :root of 10^6 +1 as given in question
# others will be 1000 
# and make the corresponding index of the bucket True
# when removing a key, if the corresponding bucket is present,
# make the value inside bucketlist at corresponding index as False



class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.hashset= [None] * self.buckets
        #print(self.hashset)
        
        
        

    def add(self, key: int) -> None:
        bucket = key % self.buckets
        bucketitem = key//self.bucketitems
        if not self.hashset[bucket]:
            if bucket == 0:
                self.hashset[bucket] = [False] * (self.bucketitems + 1)
            else:
                self.hashset[bucket] = [False]*self.bucketitems
        self.hashset[bucket][bucketitem] = True
                
        

    def remove(self, key: int) -> None:
        bucket = key%self.buckets
        bucketitem = key//self.bucketitems
        if self.hashset[bucket]:
            self.hashset[bucket][bucketitem]=False
        
        

    def contains(self, key: int) -> bool:
        bucket = key % self.buckets
        bucketitem = key//self.bucketitems
        if self.hashset[bucket]:
            return self.hashset[bucket][bucketitem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)