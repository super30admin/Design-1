#Design Hashset#
'''
This approach Uses a two-dimensional array to represent buckets.
the primary hash is used for selecting the bucket,
and the secondary hash is used for identifying the slot within that bucket.
 Each bucket slot stores a boolean to indicate the presence or absence of the key, 
 making insertion, deletion, and search operations efficient.
 Time Complexity:O(1)
'''
class MyHashSet(object):

    def __init__(self):
        self.primary_buckets = 1000
        self.secondary_buckets = 1000
        self.storage = [None] * self.primary_buckets

    def primary_hash(self, key):
        return key % self.primary_buckets

    def secondary_hash(self, key):
        return key // self.secondary_buckets

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index = key % self.primary_buckets
        secondary_index = key // self.secondary_buckets

        if self.storage[primary_index] is None:
            bucket_size = self.secondary_buckets + 1 if primary_index == 0 else self.secondary_buckets
            self.storage[primary_index] = [False] * bucket_size
        
        self.storage[primary_index][secondary_index] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index = key % self.primary_buckets
        secondary_index = key // self.secondary_buckets

        if self.storage[primary_index] is not None:
            self.storage[primary_index][secondary_index] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        primary_index = key % self.primary_buckets
        secondary_index = key // self.secondary_buckets

        return self.storage[primary_index] is not None and self.storage[primary_index][secondary_index]

    storage = [None] * 1000