#  Time Complexity : add = O(1), remove = O(1), contains = O(1)
#  Space Complexity : O(n), where n is the max(key)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        size = pow(10,6)+1
        self.li = [False for i in range(size)]        

    def hash(self, key):
        return key % size

    def add(self, key: int) -> None:
        self.li[hash(key)] = True        

    def remove(self, key: int) -> None:
        self.li[hash(key)] = False

    def contains(self, key: int) -> bool:
        return self.li[hash(key)]