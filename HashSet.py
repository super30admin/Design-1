class MyHashSet:
    def hash1(self, key):
        return key%self.size1

    def __init__(self):
        self.size1=1000001
        self.ary1=[False]*(self.size1)

    def add(self, key: int) -> None:
        h1=self.hash1(key)
        # if (not self.ary1[h1]) and (h1==0):
        #     self.ary1[h1]=[False]*(self.size1+1)
        # elif( not self.ary1[h1]):
        #         self.ary1[h1]=[False]*(self.size1)
        self.ary1[h1]=True

    def remove(self, key: int) -> None:
        h1=self.hash1(key)
        if(self.ary1[h1]):
            self.ary1[h1] = False

    def contains(self, key: int) -> bool:
        h1=self.hash1(key)
        if(self.ary1[h1]):
           return self.ary1[h1]
        
# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)