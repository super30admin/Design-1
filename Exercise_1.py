# Explain your approach in **three sentences only** at top of your code
''' Initialized an array of False with length equal to 10^6+1, the range of values
each number in set can be. A value of True means the set has the value of index as 
in the set. Because inserting will just be flipping the index to True, the 
time-complexity of inserting will be O(1).
'''

# Time Complexity : O(1)
# Space Complexity : O(N), n being the range of values that a 
# value in set can be. 
# Did this code successfully run on Leetcode : Yes. 
# Any problem you faced while coding this : Had to think a bit about 
# which is key or value before realizing it's a set. Also hesitated
# because the space complexity is O(N), with N begin 10^6+1. 


# Your code here along with comments explaining your approach
class MyHashSet:
    # Decided to initialize an array of size equal to the range
    # of numbers that can be placed into the set. 

    def __init__(self):
        self.hashset = [False]*(10**6+1)

    def add(self, key: int) -> None:
        self.hashset[key]=True

    def remove(self, key: int) -> None:
        self.hashset[key] = False

    def contains(self, key: int) -> bool:
        return self.hashset[key]