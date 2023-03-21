class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None] * self.buckets

    # as the key total size of 10^6. we take 10^3 because primary array can have collisions. for each collision we can
    # we can create a secondary array of 10^3.
    def getbuckets(self, key):   #primary hash
        return key % self.buckets    #TC: O(1) #SC:O(1)

    def getbuckitems(self, key):   #secondary hash
        return key // self.bucketitems  #TC: O(1) #SC: 0(1)
   
    def add(self, key: int) -> None:    #creating new buckets for primary and secondary hashes then checking if there are
                                        # None or Not if it  is none then no values are present then creating 2ndary hash and adding values
        bucket = self.getbuckets(key)               #TC- O(1)
        bucketitems = self.getbuckitems(key)             #SC - O(1)

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketitems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketitems
        self.storage[bucket][bucketitems] = True

    def remove(self, key: int) -> None:    #TC- O(1)
        bucket = self.getbuckets(key)       #SC - O(1)
        bucketitems = self.getbuckitems(key)

        if self.storage[bucket] == None:               #getting bucket and bucketitems. then checking if key is in the bucketitem.
            return                                      #if present returning false in 2ndary array.
        self.storage[bucket][bucketitems] = False

    def contains(self, key: int) -> bool:     #checking for key is present. if present returning else false
        bucket = self.getbuckets(key)           #TC- O(1)
        bucketitems = self.getbuckitems(key)    #SC - O(1)....


        if self.storage[bucket] == None:
            return False

        return self.storage[bucket][bucketitems]
