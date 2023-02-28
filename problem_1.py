# Time Complexity: average O(1) and worst case O(n)
# Space Complexity: O(n) (For each key it should allocate memory)

class MyHashSet:

    def __init__(self):
        self.hashset = set()
        

    def add(self, key: int) -> None:
        self.hashset.add(key)
        

    def remove(self, key: int) -> None:
        if key in self.hashset:
            self.hashset.remove(key)
        

    def contains(self, key: int) -> bool:
        if key in self.hashset: 
            return True 
        else :
            return False
        


myHashSet = MyHashSet()
myHashSet.add(1)
myHashSet.add(2)
print(myHashSet.contains(1))  
print(myHashSet.contains(3))  
myHashSet.add(2)
print(myHashSet.contains(2))  
myHashSet.remove(2)
print(myHashSet.contains(2))  