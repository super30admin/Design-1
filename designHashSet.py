#Time Complexity : O(n  )
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        self.size = 10000                 # initilizing array size to 10000 bcoz its given in the constraints
        self.table = [None] *self.size    #initilizing hash table 

    def hashcode(self,key):
        hashvalue = key % self.size       # we take the key and mod it with the size of the array to get the hashvalue.
        return hashvalue
    
    def add(self, key: int) -> None:
        hv = self.hashcode(key)           # here we get the hashvaleu(hv) so know the index position where we need to insert the key
        if self.table[hv] == None:        # we will check if at that index position in table is none, if yes then we will add our key value there.
            self.table[hv] = [key]        # adding the value of the key at that index of the table
        else:
            self.table[hv].append(key)    # if the value already exixst at that index position in the table we will append the key in that index position 

    def remove(self, key: int) -> None:
        hv = self.hashcode(key)           # we will first get the hashvalue which will help us get the index pos where we need to remove 
        if self.table[hv] !=None:         # we will check if at that index position a value exist
            while key in self.table[hv]:  # we will remove the value from that index position and 
                self.table[hv].remove(key)# we use while loop becoz we need to delete all instabces of that key in that index positon

    def contains(self, key: int) -> bool:
        hv = self.hashcode(key)           #we will first get the hashvalue to know which index position to check
        
        if self.table[hv] != None:        # if the index positopn in that table is not null
            if key in self.table[hv]:     # we will just check if the key is in the table at that index position, If yes we return True as its bool 
                return True
            else:
                return False               #else we return false
 
 