class MyHashSet(object):

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key):
        return key % self.size

    def add(self, key):
        hash_index = self._hash(key)
        bucket = self.buckets[hash_index]
        if key not in bucket:
            bucket.append(key)

    def remove(self, key):
        hash_index = self._hash(key)
        bucket = self.buckets[hash_index]
        if key in bucket:
            bucket.remove(key)

    def contains(self, key):
        hash_index = self._hash(key)
        bucket = self.buckets[hash_index]
        return key in bucket
