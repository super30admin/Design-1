class MyHashSet(object):

    def __init__(self):
        self.buckets = 10000
        self.bucketItems = 1000
        self.storage = [None] * self.size


    def get_bucket(self, key):
        return key % self.buckets
    
    def get_bucketItem(self, key):
        return key % self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.get_bucket(key)
        bucketItem = self.get_bucketItem(key)

        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [False] * self.bucketItems + 1
            else:
                self.storage[bucket] = [False] * self.bucketItems
            
        self.storage[bucket][bucketItems] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_function(key)
        if self.table[index] != None:
            while key in self.table[index]:
                self.table[index].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = self.hash_function(key)
        if self.table[index] != None:
            return key in self.table[index]
        else:
            return False