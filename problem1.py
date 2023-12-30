# class MyHashMap:

#     def __init__(self):
#         self.hash = []
#         self.count = 0
        

#     def put(self, key: int, value: int) -> None:
#         for i in self.hash:
#             if i[0] == key:
#                 i[1] = value
#                 return
#         self.count += 1
#         self.hash = self.hash + [[key, value]]

#     def get(self, key: int) -> int:
#         for i in self.hash:
#             if i[0] == key:
#                 return i[1]
#         return -1

#     def remove(self, key: int) -> None:
#         self.hash = [pair for pair in self.hash if pair[0] != key]
       


# Your MyHashMap object will be instantiated and called as such:
# myHashMap = MyHashMap()
# myHashMap.put(1, 1)
# myHashMap.put(2, 2)
# myHashMap.get(1)
# myHashMap.get(3)
# myHashMap.put(2, 1)
# myHashMap.get(2)
# myHashMap.remove(2)
# myHashMap.get(2)

class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [[]]*self.buckets
    def primary(self, key):
        return key % self.buckets
    def secondary(self, key):
        return key // self.buckets
    def put(self, key: int, value: int) -> None:
        hash1 = self.primary(key)
        hash2 = self.secondary(key)
        if self.storage[hash1] == []:
            if hash1 == 0:
                self.storage[hash1] = [-1] * (self.bucketItems+1)
            else:
                self.storage[hash1] = [-1] * self.bucketItems
        self.storage[hash1][hash2] = value

    def get(self, key: int) -> int:
        hash1 = self.primary(key)
        hash2 = self.secondary(key)
        if self.storage[hash1] == []:
            return -1
        return self.storage[hash1][hash2]

    def remove(self, key: int) -> None:
        hash1 = self.primary(key)
        hash2 = self.secondary(key)
        if self.storage[hash1] == []:
            return -1
        self.storage[hash1][hash2] = -1
