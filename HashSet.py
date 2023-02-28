# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I had hard time understanding to define size and struggled for lot of time to come up with a solution, looked at few resources and then got the basic idea

class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.hash_table = [None] * self.size
    
    def hashFunction(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        hashValue = self.hashFunction(key)
        
        if self.hash_table[hashValue] == None:
            self.hash_table[hashValue] = [key]
        else:
            self.hash_table[hashValue].append(key)

    def remove(self, key: int) -> None:
        hashValue = self.hashFunction(key)
        
        if self.hash_table[hashValue] != None:
            while key in self.hash_table[hashValue]: 
                self.hash_table[hashValue].remove(key)

    def contains(self, key: int) -> bool:
        hashValue = self.hashFunction(key)
        
        if self.hash_table[hashValue] != None:
            return key in self.hash_table[hashValue]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)