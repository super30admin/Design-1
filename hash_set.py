# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_space = 1000
        self.hash_table = [list()] * self.key_space
    
    def get_hash(self,key):
        return key % self.key_space

    def add(self, key: int) -> None:
        index = self.get_hash(key)
        if key in self.hash_table[index]:
            return
        else:
            self.hash_table[index].append(key)
        

    def remove(self, key: int) -> None:
        index = self.get_hash(key)
        try:
            self.hash_table[index].remove(key)
        except:
            pass
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = self.get_hash(key)
        return True if key in self.hash_table[index] else False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)