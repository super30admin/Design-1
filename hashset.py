# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

class MyHashSet:

    def __init__(self):
        self.myset=[[]]*1000
        self.size=1000
    
    def hash_it(self,key):
        return key%self.size

    def add(self, key: int) -> None:
        bucketId=self.hash_it(key)
        if key not in self.myset[bucketId]:
            self.myset[bucketId].append(key)

    def remove(self, key: int) -> None:
        bucketId=self.hash_it(key)
        if key in self.myset[bucketId]:
            self.myset[bucketId].remove(key)

    def contains(self, key: int) -> bool:
        bucketId=self.hash_it(key)
        return key in self.myset[bucketId]
