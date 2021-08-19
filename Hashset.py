# Time Complexity : O(logn)
# Space Complexity : 

# Is this problem on leetcode: Yes

# Your code with approach:

class MyHashSet:

    def __init__(self):
        self.size = 1000                                     # Initialize a static array
        self.table = [None] * self.size                      # Initialize a dynamic array
        
    def hash_value(self, key: int):                          # Fuction to calculate hash function
        return key % self.size
        
    def add(self, key: int) -> None:                         # Function to add 
        hv = self.hash_value(key)                            # hv stores the hash fucntion calculation
        
        if self.table[hv] == None:                           
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)
            
    def remove(self, key: int) -> None:                     # Function to remove an element
        hv = self.hash_value(key)
        if self.table[hv] != None:
            while key in self.table[hv]:
                self.table[hv].remove(key)

    def contains(self, key: int) -> bool:                    # Function will return True or False if it contains the element
        hv = self.hash_value(key)
        
        if self.table[hv] != None:
            return key in self.table[hv]
        return False
