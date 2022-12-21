# Time Complexity :
#Add,remove, contains O(1), 

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#This solution seems very trivial - not sure about a better way

class MyHashSet:

    def __init__(self):
        self.data = [False] * ((10**6) + 1 )
        self.max_value = 10 ** 6

    def hash(self,key):
        return key % self.max_value

    def add(self, key: int) -> None:
        self.data[self.hash(key)] = True

    def remove(self, key: int) -> None:
        self.data[self.hash(key)] = False

    def contains(self, key: int) -> bool:
        return self.data[self.hash(key)]
