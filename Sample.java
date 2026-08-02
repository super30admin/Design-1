// Time Complexity : O(1)
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode :Yes
class MyHashSet(object):

    def __init__(self):
        self.num_of_buckets = 1000
        self.buckets = [None] * self.num_of_buckets

    def get_primary_hash(self, key):
        return key % self.num_of_buckets

    def get_secondary_hash(self, key):
        return key // self.num_of_buckets

    def add(self, key):
        first_hash = self.get_primary_hash(key)
        if self.buckets[first_hash] == None:
            if first_hash == 0:
                self.buckets[first_hash] = [False] * (self.num_of_buckets + 1)
            else:
                self.buckets[first_hash] = [False] * (self.num_of_buckets)
        second_hash = self.get_secondary_hash(key)
        self.buckets[first_hash][second_hash] = True

    def remove(self, key):
        first_hash = self.get_primary_hash(key)
        second_hash = self.get_secondary_hash(key)
        if self.buckets[first_hash] != None:
            self.buckets[first_hash][second_hash] = False

    def contains(self, key):
        first_hash = self.get_primary_hash(key)
        second_hash = self.get_secondary_hash(key)
        if self.buckets[first_hash] != None:
            if self.buckets[first_hash][second_hash] == True:
                return True
        return False
