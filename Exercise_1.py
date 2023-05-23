"""
Time Complexity - 
add - O(1)
remove - O(1)
contains - O(1)

Space Complexity - O(1000001)
as 0 <= key <= 10^6
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