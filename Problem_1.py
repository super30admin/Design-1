# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Hashmap:
    
    # initialise a list of size 1000001 as per constraint defined 10^6
    def __init__(self):
        self.map = [-1]*1000001 

    #insert val into hashmap
    def put(self,key,val):
        self.map[key] = val
    
    # return the value stored at key passed or -1 if no value mapped to the key
    def get(self,key):
        return self.map[key]

    #assign value = -1 for the key passed
    def remove(self,key):
        self.map[key] = -1


# TC:
obj = Hashmap()
obj.put(1, 2)       
obj.put(2, 3)      
print(obj.get(1))            # returns 2
print(obj.get(3))            # returns -1 (not found)
obj.put(2, 4)                # update the existing value
print(obj.get(2))            # returns 4 
obj.remove(2)                # remove the mapping for 2
print(obj.get(2))            # returns -1 (not found)

