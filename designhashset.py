class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.buckets = [[] for _ in range(self.size)]

    def hashvalue(self, key: int):
        return key % self.size

    def add(self, key: int) -> None:
        index = self.hashvalue(key)
        if key not in self.buckets[index]: 
            self.buckets[index].append(key)

    def remove(self, key: int) -> None:
        index = self.hashvalue(key)
        if key in self.buckets[index]:
            self.buckets[index].remove(key)

    def contains(self, key: int) -> bool:
        index = self.hashvalue(key)
        return key in self.buckets[index]