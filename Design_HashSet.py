#Time complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Created a hashset with size of 10000 and made a hashtable. Gave a simple formula to calculate the hash values and used it in add, remove and for searching.
class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.table = [None] * self.size
        
    def generate_hashvalue(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        x = self.generate_hashvalue(key)
        
        if self.table[x] == None:
            self.table[x] = [key]
        else:
            self.table[x].append(key)
        

    def remove(self, key: int) -> None:
        x = self.generate_hashvalue(key)
        
        if self.table[x] != None:
            while key in self.table[x]:
                self.table[x].remove(key)
        
        

    def contains(self, key: int) -> bool:
        x = self.generate_hashvalue(key)
        
        if self.table[x] != None:
            if key in self.table[x]:
                return True
        else:
            return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
