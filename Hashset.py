# Used a fixed-size array of buckets (separate chaining) to handle collisions using modulo hashing
# Each bucket is a list that stores keys hashed to the same index.
# Operations (add, remove, contains) are performed by locating the bucket via key % n and searching within it.
class MyHashSet:

    def __init__(self):
        self.n = 10**6+1
        self.array = [[] for _ in range(self.n)]


    def add(self, key: int) -> None:
        idx = key % self.n
        if key not in self.array[idx]:
            self.array[idx].append(key)

    def remove(self, key: int) -> None:
        idx = key % self.n
        if key in self.array[idx]:
            self.array[idx].remove(key)

    def contains(self, key: int) -> bool:
        idx = key % self.n
        if key in self.array[idx]:
                return True
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)