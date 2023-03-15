#List is considered and if the list does not already contain the key, then it is appended to the set.
#Remove: Search for the key and if found, can be removed.
#Contains: Search for the key and if found, returns true otherwise false.

class MyHashSet:

    def __init__(self):
        self.hashset=[]

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.hashset.append(key)

    def remove(self, key: int) -> None:
        for k in self.hashset:
            if(k==key):
                self.hashset.remove(k)

    def contains(self, key: int) -> bool:
        for k in self.hashset:
            if k==key:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)