# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I find it difficult to translate the solution to code. I need to practice more.


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        # Using 2-dimensional array to implement the hashset
        # Initialize the primary and secondary storage for the 2-dimensional array
        self.primaryStorage = 1000
        self.secondaryStorage = 1000
        # Initialize HashSet "storage" with the primary storage size, while keeping the secondary storage null.
        self.storage = [None for _ in range(self.primaryStorage)]

    # Function to retrive index in the primary array
    def getPrimaryIndex(self, key: int):
        return key % self.primaryStorage

    # Function to retrive index in the secondary array
    def getSecondaryIndex(self, key: int):
        return key // self.secondaryStorage

    # Adding values to the HashSet
    def add(self, key: int) -> None:
        # getting index in the primary array
        primaryIndex = self.getPrimaryIndex(key)
        # If the primary index is null, initialize the secondary array with boolean values
        if not self.storage[primaryIndex]:
            # If the primary index is 0, initialize the secondary array with an additional index
            if primaryIndex == 0:
                self.storage[primaryIndex] = [False] * (self.secondaryStorage+1)
            else:
                self.storage[primaryIndex] = [False] * self.secondaryStorage
        # Get the secondary index
        secondaryIndex = self.getSecondaryIndex(key)
        # Set the value to True if it didn't exist before
        self.storage[primaryIndex][secondaryIndex] = True

    # Removing values from the HashSet
    def remove(self, key: int) -> None:
        # Get the primary index
        primaryIndex = self.getPrimaryIndex(key)
        # If the primary index is null, return as there is no value to remove
        if not self.storage[primaryIndex]:
            return
        # Get the secondary index
        secondaryIndex = self.getSecondaryIndex(key)
        # Set the value to False if it exists, thus removing it from the HashSet
        self.storage[primaryIndex][secondaryIndex] = False

    # Checking if the HashSet contains a value
    def contains(self, key: int) -> bool:
        # Get the primary index
        primaryIndex = self.getPrimaryIndex(key)
        # If the primary index is null, return False as the value is not present in the HashSet
        if not self.storage[primaryIndex]:
            return False
        # Get the secondary index
        secondaryIndex = self.getSecondaryIndex(key)
        # Return the value if it exists in the HashSet
        return self.storage[primaryIndex][secondaryIndex]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)