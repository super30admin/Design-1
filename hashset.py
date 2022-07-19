#Time Complexity - O(1)
#space complexity - O(n)
#The code ran successfully on leetcode
#I am yet to brush up on my concepts of data structures in general so I had to take help of youtube to solve this question.I plan to pick up pace as the class keeps going.I am yet to brush up my concepts on time and space complexity hence I can be wrong about both.
class MyHashSet:

    def __init__(self):
        self.size = 10000 #size of the hashset
        self.hashset = [None] * self.size #defining our hashset

    def hash_function(self,key):
        return key % self.size #hash function
    
    def add(self, key: int) -> None:
        
        hashed_value = self.hash_function(key) #hashed value obtained through hash function
        if self.hashset[hashed_value] == None: #checks whether the value at index indicated by hashed value is None
            self.hashset[hashed_value] = [key]
        else:
            self.hashset[hashed_value].append(key)

    def remove(self, key: int) -> None:
        
        hashed_value = self.hash_function(key)
        if self.hashset[hashed_value] != None: #checks whether the value at index indicated by hashed value isnt None
            while key in self.hashset[hashed_value]: #checks and removes duplicates if any
                self.hashset[hashed_value].remove(key)
                

    def contains(self, key: int) -> bool:
        hashed_value = self.hash_function(key)
        if self.hashset[hashed_value] != None: #checks and returns true or false
            return key in self.hashset[hashed_value]
        return False
