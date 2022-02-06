# -*- coding: utf-8 -*-
"""
Created on Sat Feb  5 17:47:07 2022

@author: BJay
"""
#Time complexity : put,get,remove : O(1) , Init : O(n^2)
#Space Complexity : O(n)
#Runs fine on leetcode
#Initializing the list is hurdle in python

class MyHashMap:

    def hash1(self,key):
        return key % self.size
    
    def hash2(self,key):
        return key // self.size
    
    def isBucketEmpty(self,i : int) -> bool:
        return bool(self.bucket[i])
    
    def __init__(self):
        self.size = 1000
        # self.bucket = [[None]*self.size] * self.size
        # if updating the [1][0] index value then it changes values of 0th column of each row
        self.bucket = [[None for _ in range(self.size)] for _ in range(self.size)]
        self.bucket[0].append(None)
        
        # for i in range(self.size):
        #     self.bucket.append([])
        #     for j in range(self.size):
        #         if i == 0:
        #             self.bucket[i].append(None)
        #         self.bucket[i].append(None)
        

    def put(self, key: int, value: int) -> None:
        i = self.hash1(key)
        if self.isBucketEmpty(i):
            j = self.hash2(key)
            self.bucket[i][j] = value
            

    def get(self, key: int) -> int:
        i = self.hash1(key)
        if self.isBucketEmpty(i):
            j = self.hash2(key)
            if self.bucket[i][j] != None:
                return self.bucket[i][j]
        return -1

    def remove(self, key: int) -> None:
        i = self.hash1(key)
        if self.isBucketEmpty(i):
            j = self.hash2(key)
            self.bucket[i][j] = None
        
    


# class MyHashMap:

#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.data = [-1] * 1000001

#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         self.data[key] = value

#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         return self.data[key]

#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         self.data[key] = -1




# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
