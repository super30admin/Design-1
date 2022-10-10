#Time Complexity - O(1)
# Space Complexity - O(n) (2D Array to store n values)
class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.arr = [None] * (self.size + 1)

    def hasFunc1(self, key) -> int:
        return key % self.size 
    
    def hasFunc2(self, key) -> int:
        return key // self.size 
    
    def add(self, key: int) -> None:
        index = self.hasFunc1(key)
        if self.arr[index] == None:
            self.arr[index] = [False] * (self.size+1)
        self.arr[index][self.hasFunc2(key)] = True

    def remove(self, key: int) -> None:
        index = self.hasFunc1(key)
        if self.arr[index] == None:
            return False
        self.arr[index][self.hasFunc2(key)] = False

    
    def contains(self, key: int) -> bool:
        index = self.hasFunc1(key)
        if self.arr[index] == None:
            return False
        if self.arr[index][self.hasFunc2(key)] == True:
            return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)