# Time Complexity : O(1) for put, get, remove
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach : Took a 2D array to increase the efficiency and stored the boolean values for the value existance


#2D Array
class MyHashMap(object):

    def __init__(self):
        self.hashset = [[] for i in range(1000)]
        self.bucket = 1000
        self.bucket2 = 1000



    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        hash1 = key%self.bucket
        if not self.hashset[hash1]:
            if hash1 == 0:
                self.hashset[hash1] = [-1]*1001
            else:
                self.hashset[hash1] = [-1]*1000
        hash2 = key//self.bucket2
        self.hashset[hash1][hash2] = value
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        hash1 = key%self.bucket
        hash2 = key//self.bucket2
        return -1 if not self.hashset[hash1] else self.hashset[hash1][hash2]

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hash1 = key%self.bucket
        hash2 = key//self.bucket2
        if self.hashset[hash1]:
            self.hashset[hash1][hash2] = -1
        

#1D Array
# class MyHashMap(object):

#     def __init__(self):
#         self.hashset = [None] * (1000001)


#     def put(self, key, value):
#         """
#         :type key: int
#         :type value: int
#         :rtype: None
#         """
#         if not self.hashset[key]:
#             self.hashset[key] = value
        

#     def get(self, key):
#         """
#         :type key: int
#         :rtype: int
#         """
#         return self.hashset[key]

#     def remove(self, key):
#         """
#         :type key: int
#         :rtype: None
#         """
#         if self.hashset[key]:
#             self.hashset[key] = -1

#stupid answer
# class MyHashMap(object):

#     def __init__(self):
#         self.hashmap = {}

#     def put(self, key, value):
#         """
#         :type key: int
#         :type value: int
#         :rtype: None
#         """
#         self.hashmap[key] = value
        

#     def get(self, key):
#         """
#         :type key: int
#         :rtype: int
#         """
#         return self.hashmap[key] if key in self.hashmap else -1
        

#     def remove(self, key):
#         """
#         :type key: int
#         :rtype: None
#         """
#         if key in self.hashmap:
#             del self.hashmap[key]
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)