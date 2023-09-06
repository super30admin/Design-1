class MyHashSet(object):

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size

    def _hash(self, key):
        return key % self.size

    def add(self, key):
        """
        :type key: int 
        :rtype: None
        """
        index = self._hash(key)
        if not self.buckets[index]:
            self.buckets[index] = []
        if key not in self.buckets[index]:
            self.buckets[index].append(key)


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        if self.buckets[index] and key in self.buckets[index]:
            self.buckets[index].remove(key)
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = self._hash(key)
        return self.buckets[index] and key in self.buckets[index]
        
myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)
print(myHashSet.contains(1))  # True
print(myHashSet.contains(3))  # False
myHashSet.remove(2)
print(myHashSet.contains(2))  # False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)