# Time Complexity  : O(1) for all operations
# Space Complexity : O(1) fixed size
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Yes: went back and forth to understand add funtion

# We create a storage list of 1000 slots, each slot starts as None and only builds an inner list of 1000 False values when a key needs it
# Every key maps to an exact position using key%1000 for outer slot and key//1000 for inner position
# At that position, add sets True, remove sets False, contains returns whatever is there

class MyHashSet:
    def __init__(self):
        self.hash1= 1000                                    #initializing the size of hash1 & hash2 to 1000
        self.hash2 = 1000
        self.storage = [None] *1000                         #initializing our storage with false
    
    def primary(self,key:int):
        return key % self.hash1                             #this is where we are deciding the index for the key in the storage array
    
    def secondary(self,key:int):
        return key// self.hash2                             #this is where we are deciding the index for the key in the secondary array

    def add(self, key: int) -> None:
        index = self.primary(key)                           #the key is passed in the primary function to check where we need to store the key
        if self.storage[index] is None:                     #if the index is empty the we will create a new array under the index of size 1000
            if index == 0:                                  #we will have a special case for index 0 because the 1M key will not be stored if we do not increase the size of secondary array to 1001
                self.storage[index]= [False]*(self.hash2 +1)
            else: 
                self.storage[index]= [False]*self.hash2     #for all the other keys,the size of secondary array will be 1000 only
        index2= self.secondary(key)                         #if the primary array is not empty then we will pass the key to secondary array and find it a place to store
        self.storage[index][index2]=True                    #mark the place as true where the key is stored

    def remove(self, key: int) -> None:  
        index = self.primary(key)                           #we again pass the key to primary function to find the index of the key in the storage array
        if self.storage[index] is None:                     #if it doesn not exist then we just return None
            return 
        index2 = self.secondary(key)                        #if the primary array is not empty then we will pass the key to secondary array and find it a place to remove  and return false
        self.storage[index][index2]=False
        

    def contains(self, key: int) -> bool:
        index = self.primary(key)                           #we again pass the key to primary function to find the index of the key in the storage array
        if self.storage[index] is None:                     #if it does not exist then we just return false
             return False
        index2 = self.secondary(key)                        #if the primary array is not empty then we will pass the key to secondary array and find it a place to check if the key is present or not and return true or false accordingly
        return self.storage[index][index2]
            
          