# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        self.mainSize = 10000
        self.auxiliarySize = 100
        self.hashArray = [None]*self.mainSize

    def put(self, key: int, value: int) -> None:
        hash1 = self.hashfn(key)
        if self.hashArray[hash1] is None:
            self.hashArray[hash1] = {}
        self.hashArray[hash1][key] = value
            
    def get(self, key: int) -> int:
        hash1 = self.hashfn(key)
        if self.hashArray[hash1] is not None:
            valueFound = self.hashArray[hash1].get(key)
            if valueFound is not None:
                return valueFound
        return -1

    def remove(self, key: int) -> None:
        hash1 = self.hashfn(key)
        if self.get(key) != -1:
            del self.hashArray[hash1][key]
        
    def hashfn(self,key: int) -> int:
        return key % self.mainSize