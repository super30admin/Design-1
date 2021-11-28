class MyHashSet:
    """
    Approach:
    1. Key will have values between 0 - 10^6, then we will take size of primary and                secondary array as square root of maximum value(10^6) i.e. 10^3
    2. Declare an 2D boolean array Primary array will be initailized to null and Secondary          array will initialized to false  
    3. First hashing function will decide Primary array index. Secondary function will give        the secondary array index
    4. First hashing function will return Reminder of key % bucket size
    5. Secondary hashing function will return division of key / bucket_item size
    6. Add function will first check if the index returned by first hashing function is null        in primarary array or not. If it is null then create an array of bucketitem size and        make the value of index in secondary array value at the index returned by second            hashing function as index.
    7. Remove function will first check Primary_index[null] then return nothing otherwise          make the Secondary_array[index] = false
    8. returm array[primary_index][secondary=_index]
    """
    def __init__(self):
        self.bucket = 1000
        self.bucket_item = 1000
        self.storage = [None] * self.bucket
    
    def getbucket(self, key):
        return key % self.bucket
    
    def getbucketitem(self, key):
        return key // self.bucket_item
        
    def add(self, key):
        bucket_index = self.getbucket(key)
        bucket_item_index = self.getbucketitem(key)
        if self.storage[bucket_index] == None and bucket_index == 0:
            self.storage[bucket_index] = [None] * (self.bucket_item + 1)
        elif self.storage[bucket_index] == None:
            self.storage[bucket_index] = [None] * (self.bucket_item)
        self.storage[bucket_index][bucket_item_index] = True
        print(self.storage[bucket_index][bucket_item_index])
        
    def remove(self, key):
        bucket_index = self.getbucket(key)
        bucket_item_index = self.getbucketitem(key)
        if self.storage[bucket_index] == None:
            return
        self.storage[bucket_index][bucket_item_index] = False
        
    def contains(self, key):
        bucket_index = self.getbucket(key)
        bucket_item_index = self.getbucketitem(key)
        return self.storage[bucket_index][bucket_item_index]

storage = MyHashSet()
storage.add(2)
storage.remove(2)
temp = storage.contains(2)
print(temp)