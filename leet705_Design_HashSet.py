# // Time Complexity : O(1) for all operations
# // Space Complexity : O(n) since in worst case all the keys are saved in hashset
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Squareroot, Floor and Ceil was not used at right spot

# // Your code here along with comments explaining your approach
# Approach is to used double hashing technique so that we can split the total entries into buckets
# Using key modulus with sqrt(n) to get the position in main array, then use key/sqrt(n) to find position in bucket array
# This helps avoiding collision while we are still able to access values in O(1) time complexity

# Solution
from math import sqrt
from math import ceil
from math import floor
class MyHashSet:

    def __init__(self):
        self.offset = ceil(sqrt(1000000))
        self.binArray = [None for _ in range(0,self.offset)]
        

    def add(self, key: int) -> None:
        arr1Offset = key%self.offset
        arr2Offset = floor(key/self.offset)
        if self.binArray[arr1Offset] == None:
            if arr1Offset == 0:
                self.binArray[arr1Offset] = [False for _ in range(0,self.offset+1)]
            else:
                self.binArray[arr1Offset] = [False for _ in range(0,self.offset)]
            self.binArray[arr1Offset][arr2Offset] = True
        else:
            self.binArray[arr1Offset][arr2Offset] = True
        

    def remove(self, key: int) -> None:
        arr1Offset = key%self.offset
        arr2Offset = floor(key/self.offset)
        if self.binArray[arr1Offset] != None:
            self.binArray[arr1Offset][arr2Offset] = False
        

    def contains(self, key: int) -> bool:
        arr1Offset = key%self.offset
        arr2Offset = floor(key/self.offset)
        if self.binArray[arr1Offset] == None:
            return False
        elif self.binArray[arr1Offset][arr2Offset] == True:
            return True
        
        return False