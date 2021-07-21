"""Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = [None] * 1000 

    def add(self, key: int) -> None:
        hashedVal= key % 1000
        if self.bucket[hashedVal] == None:
            if hashedVal == 0:
                self.bucket[hashedVal] = [False] * 1001
            else:
                self.bucket[hashedVal] = [False] * 1000
        doubleHashVal = key // 1000
        self.bucket[hashedVal][doubleHashVal] = True

    def remove(self, key: int) -> None:
        hashedVal = key % 1000
        if self.bucket[hashedVal] != None:
            doubleHashVal = key // 1000
            self.bucket[hashedVal][doubleHashVal] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashedVal = key % 1000
        if self.bucket[hashedVal] == None:
            return False
        else:
            doubleHashVal = key // 1000
            return self.bucket[hashedVal][doubleHashVal]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)