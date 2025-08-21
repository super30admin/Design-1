class MyHashSet:

    def __init__(self):
        self.slots = 1000
        self.eachSlot = 1000
        self.array = [None] * self.slots
    
    def hash1(self, key): 
        return key % self.slots

    def hash2(self, key): 
        return key // self.slots

    def add(self, key: int) -> None:
        
        place1 = self.hash1(key)
        place2 = self.hash2(key)

        if self.array[place1] == None: 
            if place1 == 0: 
                self.array[place1] = [False] * (self.slots + 1)

            else: 
                self.array[place1] = [False] * self.slots
            # print(self.array[place1])
        self.array[place1][place2] = True

    def remove(self, key: int) -> None:
        place1 = self.hash1(key)
        place2 = self.hash2(key)

        if self.array[place1]: 
            self.array[place1][place2] = False

    def contains(self, key: int) -> bool:
        place1 = self.hash1(key)
        place2 = self.hash2(key)

        return self.array[place1]!= None and self.array[place1][place2] 


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
