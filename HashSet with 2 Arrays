class MyHashSet:

    def __init__(self):
        self.array = [None for i in range(1000)]

    def getIndex(self,key):
        index = key % 1000
        return index
    
    def add(self, key: int) -> None:
        
        index = self.getIndex(key)
        
        if index == 0:
            if self.array[index] == None:
                newArray = [None for i in range(1001)]
                self.array[index] = newArray
        else:
            if self.array[index] == None:
                newArray = [None for i in range(1000)]
                self.array[index] = newArray
            
        newIndex = key//1000
        self.array[index][newIndex] = True
   
    def remove(self, key: int) -> None:
        
        index = self.getIndex(key)
        if self.array[index] != None:
            newIndex = key//1000
            if self.array[index][newIndex] == True:
                self.array[index][newIndex] = False
                 
    def contains(self, key: int) -> bool:
        index = self.getIndex(key)
        if self.array[index] != None:
            newIndex = key//1000
            if self.array[index][newIndex] == True:
                return True
        return False
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)