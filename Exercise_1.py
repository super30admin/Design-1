class MyHashSet:

    def __init__(self):
        self.bucket_count = 1000
        self.bucket_size = 1000
        self.storage = [None] * self.bucket_count
    
    def hash1(self, key):
        return key % self.bucket_count
    
    def hash2(self, key):
        return key // self.bucket_size
    
    def add(self, key):
        bucket = self.hash1(key)
        bucket_item = self.hash2(key)

        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucket_size + 1)
            else:
                self.storage[bucket] = [False] * self.bucket_size
        
        self.storage[bucket][bucket_item] = True
    
    def remove(self, key):
        bucket = self.hash1(key)
        bucket_item = self.hash2(key)

        if self.storage[bucket] is not None:
            self.storage[bucket][bucket_item] = False
    
    def contains(self, key):
        bucket = self.hash1(key)
        bucket_item = self.hash2(key)

        return self.storage[bucket] is not None and self.storage[bucket][bucket_item]



    

    
