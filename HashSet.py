class MyHashSet:
    def __init__(self):
        # used 10000 here because of at most constrant
        self.size = 10000
        # list of lists for given size
        self.data = [None] * self.size

    def calculate_hash_value(self, key: int) -> int:
        return key % self.size
    
    def hash_value_in_data(self, hash_value: int) -> bool:
        return self.data[hash_value] is not None

    def add(self, key: int) -> None:
        hash_value = self.calculate_hash_value(key)
        if self.hash_value_in_data(hash_value):
            self.data[hash_value].append(key)
        else:
            self.data[hash_value] = [key]

    def remove(self, key: int) -> None:
        hash_value = self.calculate_hash_value(key)
        if self.hash_value_in_data(hash_value):
            while key in self.data[hash_value]:
                self.data[hash_value].remove(key)

    def contains(self, key: int) -> bool:
        hash_value = self.calculate_hash_value(key)
        if self.hash_value_in_data(hash_value):
            return key in self.data[hash_value]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
