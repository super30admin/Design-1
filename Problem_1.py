#Time Complexity: We are able to perform add, remove and contains in O(1) time.
#Space Complexity: Extra space is O(1) for local variable.

#This code works on Leetcode.

class MyHashSet:

    def __init__(self):
        self.setSize = 1000 # define the number of buckets
        self.setItems = 1000 # define the number of items in each bucket
        self.hashSet = [None] * self.setSize #create the bucket

    def hashFunction1(self, key):
        return key % self.setSize #define the hash function for first array
    
    def hashFunction2(self,key): 
        return key // self.setSize #define the hash function for the nested array 

    def add(self, key: int) -> None:
        hash1 = self.hashFunction1(key) #get the primary hash
        if self.hashSet[hash1] == None: #check if the space has been allocated for items
            if hash1==0: # handle an edge case to accomodate value 10^6
                self.hashSet[hash1] = [False] * (self.setItems+1) #initiate the boolean array to store the elements
            else:  
                self.hashSet[hash1] = [False] * (self.setItems) #initiate the boolean array to store the elements
                #print(self.hashSet)
        hash2 = self.hashFunction2(key) #get 2nd hash 
        self.hashSet[hash1][hash2] = True #set the corresponding index to True

    def remove(self, key: int) -> None:
        hash1 = self.hashFunction1(key)
        if self.hashSet[hash1] == None: #check for empty set for a particular hash
            return None
        else:
            hash2 = self.hashFunction2(key) #check if the item exists
            self.hashSet[hash1][hash2] = False #set the element to False
        
    def contains(self, key: int) -> bool:
        hash1 = self.hashFunction1(key) #get first hash
        if self.hashSet[hash1] == None: #check if the nested array exists
            return False 
        else:
            hash2 = self.hashFunction2(key) #get the second hash
            return self.hashSet[hash1][hash2] #return the value at first and second hash
        
        return 0