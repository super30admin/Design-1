class MyHashSet:

    def __init__(self):
        self.mySet = set()

    def add(self, key: int) -> None:
        self.mySet.add(key)
        
        

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.mySet.remove(key)
        

    def contains(self, key: int) -> bool:
        return key in self.mySet



