class MyHashSet(object):

    def __init__(self):
        self.hashset = [0] * 1009

    def hashFunc(self, key):
        return key % 1000

    def secondHashFunc(self, key):
        return key // 1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashFunc(key)
        secondIndex = self.secondHashFunc(key)
        if not self.hashset[index]:
            self.hashset[index] = [0] * 1001
        self.hashset[index][secondIndex] = 1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashFunc(key)

        if self.hashset[index]:
            secondIndex = self.secondHashFunc(key)
            self.hashset[index][secondIndex] = 0

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = self.hashFunc(key)
        val = 0
        if self.hashset[index]:
            secondIndex = self.secondHashFunc(key)
            val = self.hashset[index][secondIndex]
        return val

    # Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)