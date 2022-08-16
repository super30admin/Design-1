class MyHashSet:
    def __init__(self):
        self.size = 10000
        self.data = [[None] for _ in self.size]

    def calculate_hash_value(self, key: int) -> int:
        return key % self.size
   

    def add(self, key: int) -> None:
        if not self.contains(key):
            hash_value = self.calculate_hash_value(key)
            self.data[hash_value].append(key)
        

    def remove(self, key: int) -> None:
        if self.contains(key):
            hash_value = self.calculate_hash_value(key)
            self.data[hash_value].remove(key)


    def contains(self, key: int) -> bool:
        hash_value = self.calculate_hash_value(key)
        return hash_value in self.data[hash_value]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)