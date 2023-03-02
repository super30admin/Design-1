# Time Complexity : O(1)
# Space Complexity : O(100001)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class MyHashSet(object):

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.hashSet = []
        for i in range(1000):
            self.hashSet.append(None)

    def primaryHash(self,key):
        return key % self.buckets

    def secondaryHash(self,key):
        return key // self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        pIdx = self.primaryHash(key)
        if self.hashSet[pIdx] == None:
            if pIdx == 0:
                self.hashSet[pIdx] = [False] * 1001
            else:
                self.hashSet[pIdx] = [False] * 1000
        sIdx = self.secondaryHash(key)
        self.hashSet[pIdx][sIdx] = True

    
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        pIdx = self.primaryHash(key)
        if not self.hashSet[pIdx]:
            return
        sIdx = self.secondaryHash(key)
        self.hashSet[pIdx][sIdx] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        pIdx = self.primaryHash(key)
        if not self.hashSet[pIdx]:
            return
        sIdx = self.secondaryHash(key)
        if self.hashSet[pIdx][sIdx] == True:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)