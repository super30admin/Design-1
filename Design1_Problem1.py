# Time Complexity : O(1) for put, get, remove
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach : Took a 2D array to increase the efficiency and stored the boolean values for the value existance

#2D array
class MyHashSet(object):
    
    def __init__(self):
        # self.hashset = bytearray(1000001)
        self.hashset = [[] for i in range(1000)]
        self.bucket = 1000
        self.bucket2 = 1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = key%self.bucket
        if not self.hashset[hash1]:
            if hash1 == 0:
                self.hashset[hash1] = [0]*1001
            else:
                self.hashset[hash1] = [0]*1000
        hash2 = key//self.bucket2
        self.hashset[hash1][hash2] = 1
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = key%self.bucket
        hash2 = key//self.bucket2
        if self.hashset[hash1]:
            self.hashset[hash1][hash2] = 0
        # if self.hashset[key]:
        #     self.hashset[key] = 0

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        hash1 = key%self.bucket
        hash2 = key//self.bucket2
        return False if not self.hashset[hash1] else self.hashset[hash1][hash2]

#1D Array
# class MyHashSet(object):

#     def __init__(self):
#         self.hashset = bytearray(1000001)

#     def add(self, key):
#         """
#         :type key: int
#         :rtype: None
#         """
#         if not self.hashset[key]:
#             self.hashset[key] = 1

#     def remove(self, key):
#         """
#         :type key: int
#         :rtype: None
#         """
#         if self.hashset[key]:
#             self.hashset[key] = 0

#     def contains(self, key):
#         """
#         :type key: int
#         :rtype: bool
#         """
#         return self.hashset[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)