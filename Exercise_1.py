"""
Created array list to accomodate every possible key value and assigned FALSE value to each of them
Pushing at index=key and changing value at that index to TRUE
Removal changes the value from TRUE to FALSE if key was pushed earlier, otherwise no changes
Contains returning TRUE if value at index is TRUE, because key is present, otherwise FALSE

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Time Complexity - 
add - O(1)
remove - O(1)
contains - O(1)

Space Complexity - O(1000001) to accomodate every key, because 0<=key<=1000000
"""


class MyHashSet(object):

    def __init__(self):
        self.hset=[False]*1000001
        

    def add(self, key):
        self.hset[key]=True



    def remove(self, key):
        self.hset[key]=False
        

    def contains(self, key):
        return self.hset[key]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)