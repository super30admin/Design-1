# Time Complexity :
#Add,remove, contains O(1), 

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
# Initially it had space complextiy of (O(N)) but is is more space efficient now

class MyHashSet:
    def __init__(self):
        #Create a 2D array with empty interior arrays
        self.max_value = 10 ** 3 
        self.num_buckets = 10**3
        self.data = [[]] * (self.num_buckets )

    def hash(self,key):
        #Double has function - modulo and division
        return key % self.max_value,int(key / self.num_buckets)

    def add(self, key: int) -> None:
        loc1,loc2 = self.hash(key)
        if self.data[loc1] == []:
            #If this hashed value has never been seen, then create a new internal array of bucket size
            #and then use the second hash function to place it at the right location
            if loc1 == 0 :
                self.data[loc1] = [False]*(self.max_value + 1)
            else :
                self.data[loc1] = [False]*(self.max_value)
            self.data[loc1][loc2] = True
        else :
            #If an element exist for this first hash function, then it means a collision has occured, so use the second 
            #location and place it in position 
            self.data[loc1][loc2] = True

    def remove(self, key: int) -> None:
        loc1,loc2 = self.hash(key)
        #Remove it if it exists
        if len(self.data[loc1]) != 0:
            self.data[loc1][loc2] = False

    def contains(self, key: int) -> bool:
        loc1,loc2 = self.hash(key)
        if len(self.data[loc1]) != 0:
            return self.data[loc1][loc2]
        else :
            return False
