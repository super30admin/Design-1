#I am creating a boolean array of a given size.
#For adding a key we calculate the index with hash function and then assign that index to True.
#For deleting we assign the index to False
# For contains we return True if index value is True else False
#Time Complexity =O(1)
#Space Complexity =O(1)

class MyHashSet:

    def __init__(self):
        self.size = 10**6+1
        self.hashset = [False]*self.size
        

    def add(self, key: int) -> None:
        id = key % self.size
        self.hashset[id]=True
 

    def remove(self, key: int) -> None:
        id = key % self.size
        self.hashset[id] = False

        

    def contains(self, key: int) -> bool:
        id = key % self.size
        return self.hashset[id]==True
        
