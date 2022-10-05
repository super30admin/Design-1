#   Time Complexity : add fuunction - O(1), remove function - O(1), contains function - O(1)

#   Space Complexity : O(n)
#   Did this code successfully run on Leetcode : Yes
#   Any problem you faced while coding this : It was hard to figure out the initialization of the data structure
#   in the beginning. So, I took help from the internet. It worked. 


#   Your code here along with comments explaining your approach




class MyHashSet:

    # We will initialize our data structure here.
    def __init__(self):
        
        self.size = 10000
        self.table = [None] * self.size
    
    # Creating a hash function here 
    def calculate_hash_value(self, key):
        return key % self.size

    # This function adds the key to the hashset based on the hash value if the hash value is empty. 
    # If there is already a key present at the hash value returned by the hash function, then this function will append
    # the key at that place.
    def add(self, key: int) -> None:
        hv = self.calculate_hash_value(key)
        
        if self.table[hv] == None:
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)

    # This function will remove the mentioned key from the hashset after finding its place by calculating its hash value.
    def remove(self, key: int) -> None:
        hv = self.calculate_hash_value(key)
        
        if self.table[hv] != None:
            while key in self.table[hv]: 
                self.table[hv].remove(key)

    # This function will return true if the asked key is present in the hashset. It will return false if the key
    # is not present. 
    def contains(self, key: int) -> bool:
        
        hv = self.calculate_hash_value(key)
        
        if self.table[hv] != None:
            return key in self.table[hv]
        return False