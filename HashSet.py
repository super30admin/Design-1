class MyHashSet:

    def __init__(self):
        self.data_map = [None] * 1000
    
    def hash1(self,key: int) -> None:
        hash1 = 0
        hash1 = key%1000
        return hash1
    
    def hash2(self, key:int) -> None:
        hash2 = 0
        hash2 = int(key/1000)
        return hash2

    def add(self, key: int) -> None:
        index = self.hash1(key)
        index2 = self.hash2(key)
        if(self.data_map[index] is None):
            if(index==0):
                self.data_map[index] = [None] * 1001
            else:
                self.data_map[index] = [None] * 1000
            
        self.data_map[index][index2]= key
        return True
            

    def remove(self, key: int) -> None:
        index = self.hash1(key)
        index2 = self.hash2(key)
        if(self.data_map[index] is not None):
            if(self.data_map[index][index2] == key):
                self.data_map[index][index2] = None
                return True
            else:
                return False
    
        

    def contains(self, key: int) -> bool:
        index = self.hash1(key)
        index2 = self.hash2(key)
        if(self.data_map[index] is not None):
            if(index2<=len(self.data_map[index])):
                if(self.data_map[index][index2] == key):
                    return True
                else:
                    return False
        


# Your MyHashSet object will be instantiated and called as such:
#obj = MyHashSet()
#obj.add(25)
# obj.remove(key)
# param_3 = obj.contains(key)