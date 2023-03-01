#Approach : Firstly I initiallized the Hashset table with all None values. Also added function to calculate the Hash value . In Add() it 
#will first calculate the hash value and and append the value if not NONE.For remove(), it will again calculate the Hash value and if that
# value is not None it will remove all the values for that key. And contains() will also find hash value, and if value is not NONE it will 
# check that value in HashSet, if found it will set TRUE or else FALSE.

class MyHashSet:
    def __init__(self):
        self.Hashset_size = 10000
        self.Hashset_table = [None] * self.Hashset_size

    def add(self, key: int) -> None:
        hash_value = self.calc_hash_value(key)
        if self.Hashset_table[hash_value] == None :
            self.Hashset_table[hash_value] = [key]
        else : 
            self.Hashset_table[hash_value].append(key)
    def remove(self, key: int) -> None:
        hash_value = self.calc_hash_value(key)

        if self.Hashset_table[hash_value] != None : 
            while key in self.Hashset_table[hash_value]:
                self.Hashset_table[hash_value].remove(key)
    def contains(self, key: int) -> bool:
        hash_value = self.calc_hash_value(key)
        if self.Hashset_table[hash_value] != None :
            return key in self.Hashset_table[hash_value]
        return False
    def calc_hash_value(self,key):
        return key % self.Hashset_size
        


# Your MyHashSet object will be instantiated and called as such:
myHashSet = MyHashSet()
myHashSet.add(1)    # set = [1]
myHashSet.add(2)      # set = [1, 2]
myHashSet.contains(1)  #return True
myHashSet.contains(3) # return False, (not found)
myHashSet.add(2)      # set = [1, 2]
myHashSet.contains(2) #return True
myHashSet.remove(2)   # set = [1]
myHashSet.contains(2) # return False, (already removed)