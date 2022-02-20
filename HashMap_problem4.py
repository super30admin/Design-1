# Time Complexity: O(1)     during all get, put & remove operations
# Space Complexity: O(n)    bcz of the use of additional list of list data structure.

class MyHashMap:

    def __init__(self):
        self.max = 10000
        self.dataset = [[] for i in range(self.max)]

    def _hash_function(self, key):
        return key % self.max

    def put(self, key: int, value: int) -> None:
        index = self._hash_function(key)
        for i, v in enumerate(self.dataset[index]):
            if v[0] == key:
                self.dataset[index][i] = (key, value)
                break
        else:
            self.dataset[index].append((key, value))

    def get(self, key: int) -> int:
        index = self._hash_function(key)
        for i, v in self.dataset[index]:
            if i == key:
                return v
        else:
            return -1

    def remove(self, key: int) -> None:
        index = self._hash_function(key)
        for i, v in enumerate(self.dataset[index]):
            if v[0] == key:
                del self.dataset[index][i]
                break


myHashMap = MyHashMap()
myHashMap.put(1, 1)
myHashMap.put(2, 2)
myHashMap.get(1)
myHashMap.get(3)
myHashMap.put(2, 1)
myHashMap.get(2)
myHashMap.remove(2)
myHashMap.get(2)
