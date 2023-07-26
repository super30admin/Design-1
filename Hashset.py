class MyHashSet:
    '''
    A simple implementation of a HashSet using bucket indexing.
    We use two hash functions: one for getting the bucket, and one for the 
item in the bucket.
    '''
    def __init__(self):
        '''
        Initialize the storage and set the number of buckets and items per 
bucket.
        '''
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def getBucket(self, key: int) -> int:
        '''
        Our first hash function: it determines which bucket we should 
place our item into.
        '''
        return key % self.buckets

    def getBucketItems(self, key: int) -> int:
        '''
        Our second hash function: it determines the position of the item 
within a bucket.
        '''
        return key // self.bucketItems

    def add(self, key: int) -> None:
        '''
        Add an item to our hash set. First, we determine which bucket the 
item should go in, and then the position within that bucket.
        If the bucket doesn't exist yet (i.e. it's None), we initialize 
it.
        '''
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [None] * self.bucketItems

        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        '''
        Remove an item from our hash set by setting its spot in the bucket 
to None.
        We use our hash functions to find the item's bucket and position.
        '''
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] is not None and 
self.storage[bucket][bucketItem] is not None:
            self.storage[bucket][bucketItem] = None

    def contains(self, key: int) -> bool:
        '''
        Returns true if the item exists in our hash set, and false 
otherwise.
        We find the item's bucket and position using our hash functions, 
and then check if the spot is not None.
        '''
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key) 

        if self.storage[bucket] is None:
            return False

        return self.storage[bucket][bucketItem] is True

