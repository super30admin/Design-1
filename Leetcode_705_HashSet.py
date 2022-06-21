#Time Complexity: O(1)
#Sapce Complexity: O(n)


class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.table = [None] * self.size
        
    def calculate(self, key):
        return key % self.size
        

    def add(self, key: int) -> None:
        hashvalue=self.calculate(key)
        if self.table[hashvalue]==None:
            self.table[hashvalue]=[key]
        else:
            self.table[hashvalue].append(key)

    def remove(self, key: int) -> None:
        hashvalue=self.calculate(key)
        if self.table[hashvalue]!=None:
            while key in self.table[hashvalue]:
                self.table[hashvalue].remove(key)

    def contains(self, key: int) -> bool:
        hashvalue=self.calculate(key)
        if self.table[hashvalue]!=None:
            return key in self.table[hashvalue]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)