class MyHashSet(object):

    def __init__(self):
        self.data = [False] * (10**6 + 1)
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.data[key] = True 

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.data[key] = False



    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        return self.data[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)