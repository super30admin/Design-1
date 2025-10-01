# 705. Design HashSet

# Time Complexity: O(1)
# Space Complexity: O(n)

class MyHashSet(object):
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.primaryArray = [None for i in range(self.buckets)]

    def hash1(self, inp):
        return inp%self.buckets
    
    def hash2(self, inp):
        return inp//self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.primaryArray[hash1] == None:
            if hash1 == 0:
                self.primaryArray[hash1] = [False for i in range(self.bucketItems + 1)]
            else:
                self.primaryArray[hash1] = [False for i in range(self.bucketItems)]
        
        self.primaryArray[hash1][hash2] = True        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.primaryArray[hash1] != None:
            self.primaryArray[hash1][hash2] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)

        if self.primaryArray[hash1] == None:
            return False
        
        return self.primaryArray[hash1][hash2]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
