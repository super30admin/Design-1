# TimeComplexity: O(1)
# SpaceComplexity: O(n)
# Accepted on Leetcode: https://leetcode.com/problems/design-hashset/submissions/915315294/
# Approach: created a list to add, remove and check the elements of a hashset.

class MyHashSet(object):

    def __init__(self):
        self.size = 10000
        self.table = [None] * self.size


    def hash_function(self, key):
        return key % self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_function(key)
        if self.table[index] == None:
            self.table[index] = [key]
        else:
            self.table[index].append(key)


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_function(key)
        if self.table[index] != None:
            while key in self.table[index]:
                self.table[index].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = self.hash_function(key)
        if self.table[index] != None:
            return key in self.table[index]
        else:
            return False
        
        
