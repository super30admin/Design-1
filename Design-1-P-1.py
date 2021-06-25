class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 10000000 - 1
        self.bucketitems = 1001
        self.space = [None] * self.buckets

    def get_bucket(self, key):
        return key % self.buckets

    def get_bucketitems(self, key):
        return key // self.bucketitems

    def put(self, key, value):
        """
        value will always be non-negative.
        """

        b = self.get_bucket(key)
        bitem = self.get_bucketitems(key)
        if (self.space[b] == None):
            self.space[b] = [None] * self.bucketitems
        self.space[b][bitem] = value

    def get(self, key) :
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        b = self.get_bucket(key)
        bitem = self.get_bucketitems(key)
        if (self.space[b] == None):
            return -1
        print self.space[b][bitem]

    def remove(self, key) :
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        b = self.get_bucket(key)
        bitem = self.get_bucketitems(key)
        if (self.space[b] == None):
            return
        self.space[b][bitem] = -1

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,10)
obj.put(2,20)
obj.put(3,30)
obj.put(4,40)
obj.get(1)
obj.remove(1)