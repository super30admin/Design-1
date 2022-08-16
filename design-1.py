# Time Complexity : Mentioned near each function. Overall O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.hashset = [None] * 100000
        
    def hashfunc(self, key: int) -> bool: # O(1)
        return key%100000
        
    def add(self, key: int) -> None: # O(n)
        hashvalue = self.hashfunc(key)
        if not self.contains(key):
            self.hashset[hashvalue] = [key]
        else:
            self.hashset[hashvalue].append(key)

    def remove(self, key: int) -> None: # O(n)
        hashvalue = self.hashfunc(key)
        if self.contains(key):
            while key in self.hashset[hashvalue]:
                self.hashset[hashvalue].remove(key)

    def contains(self, key: int) -> bool: # O(n)
        hashvalue = self.hashfunc(key)
        if self.hashset[hashvalue] != None:
            return key in self.hashset[hashvalue]
        return False


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))
obj.remove(2)
