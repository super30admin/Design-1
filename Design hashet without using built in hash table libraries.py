# Time Complexity: O(1) 
#  Space Complexity: O(n) 
# Did this code successfully run on Leetcode : Yes 

class HashSet:

    def __init__(self):
        self.hashset=[]

    def add(self, key: int) -> None:
        found = False
        for i, k in enumerate(self.hashset):
          if k== key:
            self.hashset[i]=key
            found = True
            break
        if not found:
            self.hashset.append(key)
          

    def remove(self, key: int) -> None:
        for i,k in enumerate(self.hashset):
            if k==key:
                del self.hashset[i]
        

    def contains(self, key: int) -> bool:
        for i,k in enumerate(self.hashset):
            if k== key:
                return True
        return False
        

class MyHashset:
    def __init__(self):
        self.keyspace =2096
        self.hash_table =[HashSet() for i in range(self.keyspace)]
    
    def hash_values(self,key):
        hash_key = key%self.keyspace
        return hash_key

    def add(self,key):
        self.hash_table[self.hash_values(key)].add(key)

    def remove(self,key):
        self.hash_table[self.hash_values(key)].remove(key)
    
    def contains(self,key):
        return self.hash_table[self.hash_values(key)].contains(key)

ob = MyHashset()
ob.add(1)
ob.add(3)

print(ob.contains(1))
print(ob.contains(3))
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)