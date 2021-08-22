# Time Complexity :

o(1)
  
# Space Complexity :

o(N)

# Did this code successfully run on Leetcode :
 yes 
  
# problems faced :

bucket = self.bucket(key) % self.buckets
bucketItem = self.getBucketItems(key) % self.bucketItems


#code

class MyHashSet(object):

        def __init__(self):

            self.buckets = 1000
            self.bucketItems = 1000
            self.storage = [[] for i in range(self.buckets)]


        def bucket(self,key):
            return key % self.buckets

        def getBucketItems(self,key):
            return key // self.bucketItems


        def add(self, key):

            bucket = self.bucket(key)
            bucketItem = self.getBucketItems(key)

            if not self.storage[bucket]:
                if bucket == 0:
                    self.storage[bucket]= [False for i in range(self.bucketItems + 1)]

                else:
                    self.storage[bucket]= [False for i in range(self.bucketItems)]


            self.storage[bucket][bucketItem] = True



        def remove(self, key):

            bucket = self.bucket(key)
            bucketItem = self.getBucketItems(key)
            if not self.storage[bucket]:
                return
            self.storage[bucket][bucketItem] = False


        def contains(self, key):

            bucket = self.bucket(key)
            bucketItem = self.getBucketItems(key)
            if not self.storage[bucket]:
                return False
            storage = self.storage
            return self.storage[bucket][bucketItem]
