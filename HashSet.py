"""
Time Complexity
#   add(key)        -> O(1) average
#   remove(key)     -> O(1) average
#   contains(key)   -> O(1) average
Worst case -> O(n) as we would need to traverse all elements if everything 
is indexed to same bucket
Space Complexity : O(n) 

Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# Used list of lists to store values, where each inner list holds keys that hash to 
# the same index. It uses hashFunction to decide which index a key should go into, 
"""

class MyHashSet(object):

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for i in range(self.size)]

    def hashFunction(self, key):
        return key % self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashFunction(key)
        if key not in self.buckets[index]:
            self.buckets[index].append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hashFunction(key)
        if key in self.buckets[index]:
            self.buckets[index].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = self.hashFunction(key)
        return key in self.buckets[index]
