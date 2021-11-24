# Program name - Design 1 - Implement hashset in python
# Author - Prajakta Pardeshi cohort Nov2021

# Time complexity for all the operations-
# put - O(1) since we use the key to put
# get - O(1) since we fetch with single key



# Space complexity for hashmap is O(n) where n is the number of elements with key value pair


cclass MyHashSet:

    def __init__(self):
        self.hashSet = set()
        

    def add(self, key: int) -> None:
         self.hashSet.add(key)

    def remove(self, key: int) -> None:
        if key in self.hashSet:
            self.hashSet.remove(key)
        

    def contains(self, key: int) -> bool:
        if key in self.hashSet:
            return True
        else:
            return False