#Time Complexity : O(1)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no 
class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.table = [[] for _ in range(self.size)]
    
    def _hash(self,key):
        return key % self.size
        
    def add(self, key: int) -> None:
        hash_index = self._hash(key)
        if key not in self.table[hash_index]:
            self.table[hash_index].append(key)


    def remove(self, key: int) -> None:
        hash_index = self._hash(key)
        if key in self.table[hash_index]:
            self.table[hash_index].remove(key)
      

    def contains(self, key: int) -> bool:
        hash_index = self._hash(key)
        if key in self.table[hash_index]:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)