# add,remove, contains = o(1)
#space complexity o(N)
class MyHashSet:

    def __init__(self):
        self.bs=1000
        self.b=[[] for _ in range(self.bs)]

    def _hash(self,key:int)->int:
        return key % self.bs
        
    def add(self, key: int) -> None:
        bi= self._hash(key)
        if key not in self.b[bi]:
            self.b[bi].append(key)

    def remove(self, key: int) -> None:
        bi = self._hash(key)
        if key in self.b[bi]:
            self.b[bi].remove(key)

    def contains(self, key: int) -> bool:
        bi = self._hash(key)
        return key in self.b[bi]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)