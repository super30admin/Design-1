# time complexity O(1) and space Complexity O(1) for all the functions.
class MyHashSet:

    def __init__(self):
        self.b=1001
        self.bi=1001
        self.arr=[None]*self.b

    def add(self, key: int) -> None:
        i=self.hf1(key)
        j=self.hf2(key)
        if self.arr[i]==None:
            self.arr[i]=[None]*self.bi
        self.arr[i][j]=True

    def remove(self, key: int) -> None:
        i=self.hf1(key)
        j=self.hf2(key)
        if self.arr[i]==None:
            return
        self.arr[i][j]=False

    def contains(self, key: int) -> bool:
        i=self.hf1(key)
        j=self.hf2(key)
        return self.arr[i]!=None and self.arr[i][j]
    def hf1(self,key):
        return key%self.b
    def hf2(self,key):
        return key//self.bi


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
