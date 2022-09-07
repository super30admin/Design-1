# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Approch to take, referred videos in order to understand the approach



class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.hash = [None]*self.size
    def hashValue(self,key):
        return key%self.size
        

    def add(self, key: int) -> None:
        hashvalue = self.hashValue(key)
        if self.hash[hashvalue] == None:
            self.hash[hashvalue] = [key]
        else:
           self.hash[hashvalue].append(key) 

    def remove(self, key: int) -> None:
        hashvalue = self.hashValue(key)
        if self.hash[hashvalue]!= None:
            while key in self.hash[hashvalue]:
                self.hash[hashvalue].remove(key)
            
        

    def contains(self, key: int) -> bool:
        hashvalue = self.hashValue(key)
        if self.hash[hashvalue]!= None:
            return key in self.hash[hashvalue]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)