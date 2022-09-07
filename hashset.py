'''
Time Complexity: O(1)
Space Complexity: O(n)
'''
class MyHashSet:
    def __init__(self, primarr_size = 1000):
        self.primarr_size = primarr_size
        self.hashset = [None]*primarr_size

    def add(self, key: int) -> None:
        prim_index = key%self.primarr_size
        if(not self.hashset[prim_index]):
            if(prim_index == 0):
                self.hashset[prim_index] = [False]*(self.primarr_size+1)
            else:
                self.hashset[prim_index] = [False]*self.primarr_size
        sec_index = int(key/self.primarr_size)
        self.hashset[prim_index][sec_index] =  True

    def remove(self, key: int) -> None:
        prim_index = key%self.primarr_size
        sec_index = int(key/self.primarr_size)
        if(self.hashset[prim_index]):
            self.hashset[prim_index][sec_index] =  False

    def contains(self, key: int) -> bool:
        prim_index = key%self.primarr_size
        sec_index = int(key/self.primarr_size)
        if(self.hashset[prim_index]):
            return self.hashset[prim_index][sec_index]
        return False
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)