# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Still trying to figure out on how to improve the space complexity keeping the Time Complexity at O(1)


# Your code here along with comments explaining your approach


class MyHashSet:

    def __init__(self):
        # Declaring an array with the size based on the max value given in the statement 
        self.size = 1000000
        self.array = [None for i in range(self.size)]

    def add(self, key: int) -> None:
        # Create a Hash Function and use it as an index to add key
        hashfunc = key % self.size
        self.array[hashfunc] = key

    def remove(self, key: int) -> None:
        # Create a Hash Function and use it as an index to remove key
        hashfunc = key % self.size
        self.array[hashfunc] = None

    def contains(self, key: int) -> bool:
        # Create a Hash Function and use it as find the key
        hashfunc = key % self.size
        return self.array[hashfunc] == key

