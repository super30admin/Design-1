#designed hashset using set() in python
#using add to add key to the set and for remove checking if any key and then removing it
#contains is checking if key is in the set
#Time Complexity: O(1)
#Space Complexity: O(n)

class MyHashSet:


    def __init__(self):
        self.myset = set()
        

    def add(self, key: int) -> None:
        self.myset.add(key)
      
        

    def remove(self, key: int) -> None:
        if key in self.myset:
            self.myset.remove(key)

 

    def contains(self, key: int) -> bool:
        return key in self.myset
       