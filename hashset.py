#Time Complexity :
#add: O(1)
#remove: O(1)
#contains: O(1)
# Space Complexity : O(N), N being the input size

# In the worst case, if all 10^6 keys are added, space will be:
# 1000 outer buckets, each with 1001 bool values → O(1,001,000) ~ O(10^6) total.
# However, lazy allocation ensures that only buckets needed are actually created

# Did this code successfully run on Leetcode : Yes


#Used A double hashing (a 2-level hashing technique) to simulate a space-efficient HashSet with reduced collisions.


class MyHashSet(object):

    def __init__(self):
        self.buckets = 1000
        self.bucketlists = 1001
        self.storage = [None] * self.buckets
    
    def _hash1(self, key):
        return key % self.buckets

    def _hash2(self, key):
        return key // self.bucketlists
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx1 = self._hash1(key)
        if self.storage[idx1] == None:
            self.storage[idx1] = [False] * self.bucketlists
        idx2 = self._hash2(key)
        self.storage[idx1][idx2] = True


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx1 = self._hash1(key)
        if self.storage[idx1] == None:
            return
        idx2 = self._hash2(key)
        self.storage[idx1][idx2] = False
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        idx1 = self._hash1(key)
        idx2 = self._hash2(key)
        return self.storage[idx1] != None and self.storage[idx1][idx2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)