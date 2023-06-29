# Time Complexity: O(1)
# Space Complexity: O(n)
class MyHashSet:

    def __init__(self):
        self.bucket_size = 1000
        self.bucket = [[] for _ in range(self.bucket_size)]

    def add(self, key: int) -> None:
        index = key % self.bucket_size
        secondary_index = key // self.bucket_size
        if secondary_index >= len(self.bucket[index]):
            self.bucket[index].extend([None] * (secondary_index - len(self.bucket[index]) + 1))
        self.bucket[index][secondary_index] = True

    def remove(self, key: int) -> None:
        index = key % self.bucket_size
        secondary_index = key // self.bucket_size
        if secondary_index < len(self.bucket[index]):
            self.bucket[index][secondary_index] = False

    def contains(self, key: int) -> bool:
        index = key % self.bucket_size
        secondary_index = key // self.bucket_size
        if secondary_index < len(self.bucket[index]) and self.bucket[index][secondary_index] is True:
            return True
        else:
            return False


obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))
obj.add(1000000)
print(obj.contains(1000000))