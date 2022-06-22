class MyHashSet(object):

    def __init__(self):
        self.buckets =1000
        self.bucketItems =1000
        self.array = [[] for _ in range(1000)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        subkey = key%self.buckets
        if not self.contains(key):
            self.array[subkey].append(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        subkey = key%self.buckets
        if key in self.array[subkey]:
            self.array[subkey].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        subkey = key%1000
        return key in self.array[subkey]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)