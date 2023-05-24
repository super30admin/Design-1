# Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Passed all the test cases
#Any problem you faced while coding this : I had little hard time developing contains function

class HashSet:
    #This function creates a hastable and intialized the size of the table
    def __init__(self):
        self.size = 1000
        self.hashtable = [None] * self.size

    def hashfunction(self, key):
        #This is the hash function that hashes the key values
        return key % self.size

    def add(self, key: int) -> None:
        #Checks the hash table and adds the hashed value to the table
        hv = self.hashfunction(key)
        if self.hashtable[hv] == None:
            self.hashtable[hv] = [key]
        else:
            self.hashtable[hv].append(key)

    def remove(self, key: int):
        #remove the key element if its present in the table and do nothing if the element is not there in the table
        hv = self.hashfunction(key)
        if self.hashtable[hv] is not None:
            while key in self.hashtable[hv]:
                self.hashtable[hv].remove(key)

    def contains(self, key: int) -> bool:
        #Checks if the element is present in the hash table and return false if there is no element in the table
        hv = self.hashfunction(key)

        if self.hashtable[hv] != None:
            if key in self.hashtable[hv]:
                return True
        else:
            return False
