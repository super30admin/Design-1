

# Time Complexity : O(1) for insertion, removal and contains method
# Space Complexity : 
    # Primary Array is of fixed size since we have initialized it as 1000
    # Secondary Array is only assigned at a specific index of primary array if want to add at that index.
    # So overall complexity O(n) in worst case which entirely depends on our inputs.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this :
    # I understand Java but prefer to code in python, so understanding and implementing
    # the same solution in Python was a challenging part.
    # Understood the Logic.

#  Your code here along with comments explaining your approach

#create class
class MyHashSet:

    #initialize size of our primary and secondary arrays
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        #initally the primary array is filled with None of size 1000
        #Python byDefault does not initialize to False or Empty
        self.storage = [None] * self.buckets

    #take mode and return the index for the key in the primary array
    def getPrimaryIndex(self, key : int)-> int:
        return key % self.buckets

    #divide key by the size of bucketItem to get its corresponding index in the secondary array
    def getSecondaryIndex(self, key : int)-> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        #get appropriate index based on the key
        primaryIndex = self.getPrimaryIndex(key)
        secondaryIndex = self.getSecondaryIndex(key)

        #check if there is an associated array at a given index in primary array, if not initialize it
        #if the primaryindex is 0 then add one more bucket to the secondary array at position 0
        #to handle case such as 10^6
        #if already exists then just set value at that position to True
        if self.storage[primaryIndex] is None:
            if primaryIndex == 0:
                self.storage[primaryIndex] = [False] * (self.bucketItems + 1)
            else:
                self.storage[primaryIndex] = [False] * (self.bucketItems)

        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key: int) -> None:
        #get appropriate index based on the key
        primaryIndex = self.getPrimaryIndex(key)
        secondaryIndex = self.getSecondaryIndex(key)

        #if the value in the primary array at the primaryindex is Empty, so we do not need to do anything
        #since the secondary array does not exist for it
        #so simpy return
        #otherwise we need set the value at the secondaryIndex to False
        if self.storage[primaryIndex] is None:
            return
           
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key: int) -> bool:
        #get appropriate index based on the key
        primaryIndex = self.getPrimaryIndex(key)
        secondaryIndex = self.getSecondaryIndex(key)

        #if the value in the primary array at the primaryindex is Empty, so we do not need to do anything
        #since the secondary array does not exist for it
        #so simpy return False
        #otherwise we need set the value at the secondaryIndex to True
        if self.storage[primaryIndex] is None:
            return False
        
        return self.storage[primaryIndex][secondaryIndex]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)