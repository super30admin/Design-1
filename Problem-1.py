# // Time Complexity : O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Concept wise clear and able to code


# // Your code here along with comments explaining your approach
# I have hard coded the primary array size which can also be declared as the square root of the range.
# I have defined two hash functions, one is to decide the position in the primary array and then to decide
#  the position in the subarray.


class MyHashSet:
    

    def __init__(self):
        self.arrayRange = 1000
        self.primaryArray = [None]*1000

    def add(self, key: int) -> None:
        hash1 = int(key % self.arrayRange)
        hash_again = int(key / self.arrayRange)
        if self.primaryArray[hash1] == None:
            if hash1 == 0:
                self.primaryArray[hash1] = [None]*(self.arrayRange+1)
            else:
                self.primaryArray[hash1] = [None]*(self.arrayRange)
        self.primaryArray[hash1][hash_again] = True

    def remove(self, key: int) -> None:
        hash1 = int(key % self.arrayRange)
        hash_again = int(key / self.arrayRange)
        if self.primaryArray[hash1] == None:
            return ""
        self.primaryArray[hash1][hash_again] = False 
# 
    def contains(self, key: int) -> bool:
        hash1 = int(key % self.arrayRange)
        hash_again = int(key / self.arrayRange)
        if self.primaryArray[hash1] == None:
            return False
        else:
            return self.primaryArray[hash1][hash_again]